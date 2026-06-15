package com.keith.bank;

public class Main {
    public static void main(String[] args) {
        Account a = new Account("A1", "Alice", 100.0);
        a.deposit(50);
        a.withdraw(30);
        System.out.println(a);
        
        SavingsAccount s = new SavingsAccount("S1", "Bob", 1000.0, 0.02);
        s.applyInterest();
        System.out.println(s);
    }
}