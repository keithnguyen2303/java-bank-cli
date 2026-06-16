package com.keith.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void depositIncreasesBalance() {
        Account account = new Account("A1", "Alice", 100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void withdrawDecreasesBalance() throws InsufficientFundsException {
        Account account = new Account("A1", "Alice", 100.0);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance());
    }

    @Test
    void withdrawingMoreThanBalanceThrows() {
        Account account = new Account("A1", "Alice", 100.0);
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(500.0));
    }

    @Test
    void negativeDepositThrows() {
        Account account = new Account("A1", "Alice", 100.0);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }

    @Test
    void accountsWithSameIdAreEqual() {
        Account a = new Account("SAME", "Alice", 100.0);
        Account b = new Account("SAME", "Bob", 200.0);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }
}