package org.tr;

/**
 * Coding Assignment
 * You are asked to develop a small application for trade reporting.
 * Traders execute trades with external brokers and manually input the trade information into our internal
 * trade booking system. Trades can be of different financial products including FX Forward, Bond Futures,
 * Interest Rate Swaps, etc. Traders use different brokers to execute their trades. e.g. One FX Forward
 * trade is executed on Broker-A. Another FX Forward trade is executed on Broker-B.
 * Now, we want to generate report file for “FX Forward Trade, Broker-A”.
 * A sample output the report for “FX forward trades” executed on “Broker A” on “8th Apr 2020” looks like
 * this:
 * tradeRef,productId,productName,tradeDate,qty,buySell,price
 * T-FWD-1,1,AUDNZD FRD Exp14Jul2021,20200408,1000000,B,1.067591
 * T-FWD-2,2,AUDUSD FRD Exp15Jul2021,20200408,8000000,S,0.7518301
 * T-FWD-3,3,EURUSD FRD Exp15Jul2021,20200408,25000000,B, 1.186073
 * .....
 * We will need to further expand to generate reports for other “Product type – Broker” combination.
 * Their report formats can be slightly different. So, the class design should be flexible enough to adapt to
 * these new requirements.
 * You should
 * - Develop the reporting application using C#, Java, Kotlin or Groovy.
 * - Some of the requirements may not have been specified. Please state the assumptions you have
 * made.
 * - Make sure the code is of good quality which is easy to maintain and extend.
 * - In this exercise, you do not need to use a real database. Feel free to create a stub which contains
 * dummy trades you needed.
 * Deliverables
 * - Source code + any supporting materials (if any)
 * - A short readme file (get started guide)
 * We will evaluate your solution based on
 * - System design
 * - Code quality
 * - Test cases
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Please run tests.");
    }
}
