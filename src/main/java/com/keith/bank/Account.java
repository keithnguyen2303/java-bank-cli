package com.keith.bank;

public class Account {
    private final String id; // private = hidden internal state (encapsulation)
    private final String owner;
    private double balance;

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
    }

    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance)
            throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account[%s] %s: $%.2f", id, owner, balance);
    }
}