package com.keith.bank;

public class Main {
    public static void main(String[] args) {
        Account a = new Account("A1", "Alice", 100.0);
        a.deposit(50);
        a.withdraw(30);
        System.out.println(a);   // calls toString() automatically
    }
}