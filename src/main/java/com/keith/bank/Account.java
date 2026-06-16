package com.keith.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account other = (Account) o;
        return id.equals(other.id);            // two accounts are "equal" if same id
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);               // must be consistent with equals
    }

    @Override
    public String toString() {
        return String.format("Account[%s] %s: $%.2f", id, owner, balance);
    }
}