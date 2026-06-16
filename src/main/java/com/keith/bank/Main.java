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

        System.out.printf("Total assets: $%.2f%n", bank.totalAssets());
        bank.richestAccount().ifPresent(acc -> System.out.println("Richest: " + acc));

        bank.findAccount("A1").ifPresent(alice -> {
            System.out.println("\nAlice's transactions:");
            for (Transaction t : alice.getHistory()) {
                System.out.printf("  %s $%.2f at %s%n", t.type(), t.amount(), t.timestamp());
            }
        });
    }
}