package org.example;

import org.example.Bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void testCreateAccWithValidInitialBalance() {
        Bank bank = new Bank(100.0);
        assertEquals(100.0, bank.getBalance(), 0.001);
    }

    @Test
    public void testCreateAccWithInvalidInitBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Bank(-100.0);
        });
        assertEquals("Initial balance cannot be negative", exception.getMessage());
    }

    @Test
    public void testValidDeposit() {
        Bank bank = new Bank(100.0);
        bank.plus_balance(50.0);
        assertEquals(150.0, bank.getBalance(), 0.001);
    }

    @Test
    public void testInvalidDeposit() {
        Bank bank = new Bank(100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.plus_balance(-50.0);
        });
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    public void testMinusValid() {
        Bank bank = new Bank(100.0);
        bank.minus_balance(50.0);
        assertEquals(50.0, bank.getBalance(), 0.001);
    }

    @Test
    public void testMinusMoreThanBalance() {
        Bank bank = new Bank(100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.minus_balance(150.0);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    public void testMinusInvalid() {
        Bank bank = new Bank(100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.minus_balance(-50.0);
        });
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    public void testManyOperationsWithoutErrors() {
        Bank bank = new Bank(100.0);
        int operations = 100000;

        bank.many_operations(operations);

        assertTrue(bank.getBalance() >= 0, "Negative balance");
    }


}
