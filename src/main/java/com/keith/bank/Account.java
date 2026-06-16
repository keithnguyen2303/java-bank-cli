package com.keith.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    private final String id;
    private final String owner;
    private double balance;
    private final List<Transaction> history = new ArrayList<>();

    public Account(String id, String owner, double openingBalance) {
        this.id = id;
        this.owner = owner;
        this.balance = openingBalance;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
        history.add(Transaction.of(TransactionType.DEPOSIT, amount));
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0)
            throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance)
            throw new InsufficientFundsException("Insufficient funds for " + id);
        balance -= amount;
        history.add(Transaction.of(TransactionType.WITHDRAWAL, amount));
    }

    public List<Transaction> getHistory() {
        return Collections.unmodifiableList(history); // callers can read but not mutate our list
    }

    @Override
    public String toString() {
        return String.format("Account[%s] %s: $%.2f", id, owner, balance);
    }
}