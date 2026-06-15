package com.keith.bank;

public class SavingsAccount extends Account {
    private final double interestRate; // e.g. 0.02 == 2%

    public SavingsAccount(String id, String owner, double openingBalance, double interestRate) {
        super(id, owner, openingBalance); // calls Account's constructor
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        deposit(getBalance() * interestRate); // reuses Account's validated deposit()
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (savings @ %.1f%%)", interestRate * 100);
    }
}