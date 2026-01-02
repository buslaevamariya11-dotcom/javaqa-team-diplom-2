package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void shouldNotLoseMoneyIfTransferToAccountWithLimitFailed() {
        Bank bank = new Bank();
        SavingAccount from = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5);
        SavingAccount to = new SavingAccount(
                2_000,
                1_000,
                3_000,
                5);

        bank.transfer(from, to, 2_000);

        Assertions.assertEquals(2_000, from.getBalance());
        Assertions.assertEquals(2_000, to.getBalance());
    }

    @Test
    public void shouldReturnFalseIfTransferFailed() {
        Bank bank = new Bank();
        SavingAccount from = new SavingAccount(
                1_500,
                1_000,
                5_000,
                5);
        SavingAccount to = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5);

        boolean result = bank.transfer(from, to, 1_000);

        Assertions.assertFalse(result, "Метод должен возвращать false, если перевод не удался");
    }

    @Test
    public void shouldNotTransferNegativeAmount() {
        Bank bank = new Bank();
        SavingAccount from = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5);
        SavingAccount to = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5);

        boolean result = bank.transfer(from, to, -500);

        Assertions.assertFalse(result);
        Assertions.assertEquals(2_000, from.getBalance());
        Assertions.assertEquals(2_000, to.getBalance());
    }

    @Test
    public void shouldTransferMoneySuccessfully() {
        Bank bank = new Bank();
        SavingAccount from = new SavingAccount(
                3_000,
                1_000,
                5_000,
                5);
        SavingAccount to = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5);

        boolean result = bank.transfer(from, to, 1_000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(2_000, from.getBalance());
        Assertions.assertEquals(3_000, to.getBalance());
    }

    @Test
    public void shouldReturnFalseIfAmountIsZero() {
        Bank bank = new Bank();
        SavingAccount from = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5);
        SavingAccount to = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5);

        boolean result = bank.transfer(from, to, 0);

        Assertions.assertFalse(result);
    }

    @Test
    public void shouldTransferEverythingToMinBalance() {
        Bank bank = new Bank();
        SavingAccount from = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5);
        SavingAccount to = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5);

        boolean result = bank.transfer(from, to, 1_000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(1_000, from.getBalance());
        Assertions.assertEquals(3_000, to.getBalance());
    }
}