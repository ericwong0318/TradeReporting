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
*
    - Develop the reporting application using C#, Java, Kotlin or Groovy.
*
    - Some of the requirements may not have been specified. Please state the assumptions you have
* made.
*
    - Make sure the code is of good quality which is easy to maintain and extend.
*
    - In this exercise, you do not need to use a real database. Feel free to create a stub which contains
* dummy trades you needed.
* Deliverables
*
    - Source code + any supporting materials (if any)
*
    - A short readme file (get started guide)
* We will evaluate your solution based on
*
    - System design
*
    - Code quality
*
    - Test cases
      */

# Coding Assignment

# Assumption

Assume the brokers manually input the trade information.
Assume we can find the product type from the product id.
Goal: Generate reports for any “Product type – Broker” combinations.
Assume the log is seperately store.

# Tools

Intellij, Maven for organizing the project

# Test

There are 4 test written in JUnit. The tests have mock input and assert its output.

# Run the test

`mvn test`

# Result

```
➜ TradeReporting mvn test

[INFO] Scanning for projects...
[INFO]
[INFO] ---------------------< org.example:TradeReporting >---------------------
[INFO] Building TradeReporting 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ TradeReporting ---
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO]
[INFO] --- compiler:3.13.0:compile (default-compile) @ TradeReporting ---
[INFO] Recompiling the module because of added or removed source files.
[INFO] Compiling 3 source files with javac [debug target 19] to target/classes
[WARNING] location of system modules is not set in conjunction with -source 19
not setting the location of system modules may lead to class files that cannot run on JDK 19
--release 19 is recommended instead of -source 19 -target 19 because it sets the location of system modules
automatically
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ TradeReporting ---
[INFO] skip non existing resourceDirectory /Users/ericw/TradeReporting/src/test/resources
[INFO]
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ TradeReporting ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 1 source file with javac [debug target 19] to target/test-classes
[WARNING] location of system modules is not set in conjunction with -source 19
not setting the location of system modules may lead to class files that cannot run on JDK 19
--release 19 is recommended instead of -source 19 -target 19 because it sets the location of system modules
automatically
[INFO]
[INFO] --- surefire:3.2.5:test (default-test) @ TradeReporting ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
Downloading from
central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.5/surefire-junit-platform-3.2.5.pom
Downloaded from
central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.5/surefire-junit-platform-3.2.5.pom (
4.7 kB at 7.8 kB/s)
Downloading from
central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/3.2.5/surefire-providers-3.2.5.pom
Downloaded from
central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/3.2.5/surefire-providers-3.2.5.pom (
2.6 kB at 46 kB/s)
Downloading from
central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.5/common-java5-3.2.5.pom
Downloaded from
central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.5/common-java5-3.2.5.pom (2.8
kB at 67 kB/s)
Downloading from
central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-launcher/1.9.3/junit-platform-launcher-1.9.3.pom
Downloaded from
central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-launcher/1.9.3/junit-platform-launcher-1.9.3.pom (
3.0 kB at 112 kB/s)
Downloading from
central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.5/surefire-junit-platform-3.2.5.jar
Downloaded from
central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.5/surefire-junit-platform-3.2.5.jar (
27 kB at 445 kB/s)
Downloading from
central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.5/common-java5-3.2.5.jar
Downloading from
central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-launcher/1.9.3/junit-platform-launcher-1.9.3.jar
Downloaded from
central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.5/common-java5-3.2.5.jar (18 kB
at 627 kB/s)
Downloaded from
central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-launcher/1.9.3/junit-platform-launcher-1.9.3.jar (
169 kB at 863 kB/s)
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running Tests
/Users/ericw/TradeReporting/brokerA_20200408_fx-file.txt
/Users/ericw/TradeReporting/brokerB_20200408_fx-file.txt
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.051 s -- in Tests
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.801 s
[INFO] Finished at: 2024-07-23T02:04:43+08:00
[INFO] ------------------------------------------------------------------------
➜ TradeReporting 
```
