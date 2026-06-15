# Java Bank CLI

A small command-line bank app to practice Java OOP, Collections, and Java 8 features.

## Run

    mvn compile exec:java

## Features

- Account with encapsulated balance (deposit/withdraw with validation)
- SavingsAccount subclass with interest (inheritance + overriding)
- Bank using HashMap for account storage, Optional for safe lookups
- Custom checked exception for insufficient funds
- Java 8 streams for total assets and richest-account reporting