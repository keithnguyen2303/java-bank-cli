# Java Bank CLI

A small command-line bank app to practice Java OOP, Collections, and Java 8 features.

## Run

    mvn compile exec:java

## Build a runnable jar

    mvn package
    java -jar target/java-bank-cli-1.0-SNAPSHOT.jar

## Features

- Account with encapsulated balance and full transaction history
- SavingsAccount (inheritance) implementing an InterestBearing interface
- Bank using HashMap storage, Optional lookups, and stream reports
- Custom checked exception for insufficient funds
- equals/hashCode by account id; balance-sorted reporting
- JUnit 5 test suite; packaged as an executable uber-jar via Maven Shade