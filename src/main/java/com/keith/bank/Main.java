package com.keith.bank;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        Bank bank = new Bank();
        bank.openAccount(new Account("A1", "Alice", 100.0));
        bank.openAccount(new SavingsAccount("S1", "Bob", 1000.0, 0.02));

        bank.transfer("S1", "A1", 200.0);

        for (Account acc : bank.allAccounts()) {
            System.out.println(acc);
        }
    }
}