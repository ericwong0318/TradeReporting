import static org.junit.jupiter.api.Assertions.assertEquals;

import org.tr.Log;
import org.tr.Logs;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Tests {

    @Test
    void testLogWith1Item() {
        Logs logs = new Logs("brokerA", 20200408);
        logs.addLogs(new Log("T-FWD-1", 1, "AUDNZD FRD Exp14Jul2021", 20200408,
                1000000, 'B', 1.067591));
        assertEquals("[T-FWD-1,1,AUDNZD FRD Exp14Jul2021,20200408,1000000,B,1.067591]", logs.getLogs().toString());
    }

    @Test
    void testLogWith2Items() {
        Logs logs = new Logs("brokerA", 20200408);
        logs.addLogs(new Log("T-FWD-1", 1, "AUDNZD FRD Exp14Jul2021", 20200408,
                1000000, 'B', 1.067591));
        logs.addLogs(new Log("T-FWD-2", 2, "AUDUSD FRD Exp15Jul2021", 20200408,
                8000000, 'S', 0.7518301));
        assertEquals("[T-FWD-1,1,AUDNZD FRD Exp14Jul2021,20200408,1000000,B,1.067591, " +
                "T-FWD-2,2,AUDUSD FRD Exp15Jul2021,20200408,8000000,S,0.7518301]", logs.getLogs().toString());
    }

    @Test
    public void testGenerateFile() throws IOException {
        // make logs
        Logs logs = new Logs("brokerA", 20200408);
        logs.addLogs(new Log("T-FWD-1", 1, "AUDNZD FRD Exp14Jul2021", 20200408,
                1000000, 'B', 1.067591));
        logs.addLogs(new Log("T-FWD-2", 2, "AUDUSD FRD Exp15Jul2021", 20200408,
                8000000, 'S', 0.7518301));
        logs.addLogs(new Log("T-BondFutures-4", 4, "BondFutures Exp15Jul2021", 20200408,
                8000000, 'S', 0.7518301));

        // generate report
        System.out.println(logs.generateFxFile("FX Forward Trades"));

        // assertion
        Path file = Path.of("", ".").resolve("brokerA_20200408_fx-file.txt");
        String content = Files.readString(file);
        assertEquals(
                "tradeRef,productId,productName,tradeDate,qty,buySell,price\n" +
                        "T-FWD-1,1,AUDNZD FRD Exp14Jul2021,20200408,1000000,B,1.067591\n" +
                        "T-FWD-2,2,AUDUSD FRD Exp15Jul2021,20200408,8000000,S,0.7518301\n",
                content);
    }

    @Test
    public void testOtherCombination() throws IOException {
        // make logs
        Logs logs = new Logs("brokerB", 20200408);
        logs.addLogs(new Log("T-FWD-1", 1, "AUDNZD FRD Exp14Jul2021", 20200408,
                1000000, 'B', 1.067591));
        logs.addLogs(new Log("BondFutures", 4, "AUDNZD FRD Exp14Jul2021", 20200408,
                1000000, 'B', 1.067591));
        logs.addLogs(new Log("BondFutures", 4, "AUDUSD FRD Exp15Jul2021", 20200408,
                8000000, 'S', 0.7518301));
        logs.addLogs(new Log("T-Other", 5, "Other Exp15Jul2021", 20200408,
                8000000, 'S', 0.7518301));

        // generate report
        System.out.println(logs.generateFxFile("Bond Futures"));

        // assertion
        Path file = Path.of("", ".").resolve("brokerB_20200408_fx-file.txt");
        String content = Files.readString(file);
        assertEquals(
                "tradeRef,productId,productName,tradeDate,qty,buySell,price\n" +
                        "BondFutures,4,AUDNZD FRD Exp14Jul2021,20200408,1000000,B,1.067591\n" +
                        "BondFutures,4,AUDUSD FRD Exp15Jul2021,20200408,8000000,S,0.7518301\n",
                content);
    }
}