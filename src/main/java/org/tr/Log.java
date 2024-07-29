package org.tr;

public class Log {
    // tradeRef,productId,productName,tradeDate,qty,buySell,price
    // T-FWD-1,1,AUDNZD FRD Exp14Jul2021,20200408,1000000,B,1.067591
    private String tradeRef;
    private int productId;
    private String productName;
    private int tradDate;
    private int qty;
    private char buySell;
    private double price;

    public Log(String tradeRef, int productId, String productName, int tradDate, int qty, char buySell, double price) {
        this.tradeRef = tradeRef;
        this.productId = productId;
        this.productName = productName;
        this.tradDate = tradDate;
        this.qty = qty;
        this.buySell = buySell;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return tradeRef +
                "," + productId +
                "," + productName +
                "," + tradDate +
                "," + qty +
                "," + buySell +
                "," + price;
    }
}
