package com.keith.bank;

public class SavingsAccount extends Account implements InterestBearing {
    private final double interestRate; // e.g. 0.02 == 2%

    public SavingsAccount(String id, String owner, double openingBalance, double interestRate) {
        super(id, owner, openingBalance); // calls Account's constructor
        this.interestRate = interestRate;
    }

    @Override
    public void applyInterest() {
        deposit(getBalance() * interestRate);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (savings @ %.1f%%)", interestRate * 100);
    }
}