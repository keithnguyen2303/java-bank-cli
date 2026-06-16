package com.keith.bank;

import java.time.LocalDateTime;

public record Transaction(TransactionType type, double amount, LocalDateTime timestamp) {
    public static Transaction of(TransactionType type, double amount) {
        return new Transaction(type, amount, LocalDateTime.now());
    }
}