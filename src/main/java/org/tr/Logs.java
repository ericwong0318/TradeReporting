package org.tr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logs {
    List<Log> logs = new ArrayList<Log>();
    private String broker;
    private int date;

    public Logs(String broker, int date) {
        this.broker = broker;
        this.date = date;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void addLogs(Log newAddedLog) {
        this.logs.add(newAddedLog);
    }

    public String getProductType(int productId) {
        if (productId == 1 || productId == 2 || productId == 3) {
            return "FX Forward Trades";
        } else if (productId == 4) {
            return "Bond Futures";
        } else if (productId == 5) {
            return "Interest Rate Swaps";
        } else {
            throw new RuntimeException("product type");
        }
    }

    public String generateFxFile(String requiredProductType) {
        String fileName = System.getProperty("user.dir") + "/" + this.broker + "_" + this.date + "_fx-file.txt";

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            // write header
            fileWriter.write("tradeRef,productId,productName,tradeDate,qty,buySell,price\n");
        } catch (IOException ex) {
            System.out.println(ex);
        }

        // write body
        for (Log log : this.logs) {
            String logProductType = getProductType(log.getProductId());
            if (!logProductType.equals(requiredProductType)) {
                continue;
            }
            try {
                fileWriter.write(log.toString());
                fileWriter.write("\n");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

        // close file writer
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fileName;
    }
}
