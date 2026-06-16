package com.keith.bank;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Bank {
    private final Map<String, Account> accounts = new HashMap<>();

    public void openAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public Optional<Account> findAccount(String id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public void transfer(String fromId, String toId, double amount)
            throws InsufficientFundsException {
        Account from = findAccount(fromId)
                .orElseThrow(() -> new IllegalArgumentException("No account " + fromId));
        Account to = findAccount(toId)
                .orElseThrow(() -> new IllegalArgumentException("No account " + toId));
        from.withdraw(amount);
        to.deposit(amount);
    }

    public Collection<Account> allAccounts() {
        return accounts.values();
    }

    public double totalAssets() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    public Optional<Account> richestAccount() {
        return accounts.values().stream()
                .max(java.util.Comparator.comparingDouble(Account::getBalance));
    }

    public List<Account> accountsByBalanceDesc() {
        return accounts.values().stream()
                .sorted(Comparator.comparingDouble(Account::getBalance).reversed())
                .collect(Collectors.toList());
    }

    public void applyInterestToAll() {
        for (Account account : accounts.values()) {
            if (account instanceof InterestBearing bearing) {   // checks type AND casts in one step
                bearing.applyInterest();
            }
        }
    }

}