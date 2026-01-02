package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void shouldThrowExceptionForNegativeLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    0,
                    -5_000,
                    15);
        });
    }

    @Test
    public void shouldPayEquallyToLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15);
        boolean result = account.pay(
                5_000);

        Assertions.assertTrue(result);

        Assertions.assertEquals(
                -5_000, account.getBalance());
    }

    @Test
    public void shouldSubtractFromExistingBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15);
        account.pay(
                500);

        Assertions.assertEquals(
                500, account.getBalance());
    }

    @Test
    public void shouldNotCalculateRateIfBalanceIsPositive() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15);

        Assertions.assertEquals(
                0, account.yearChange());
    }

    @Test
    public void shouldCalculateRateOnSmallNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15);
        account.pay(
                80);

        Assertions.assertEquals(
                -12, account.yearChange());
    }

    @Test
    public void shouldCreateAccountWithZeroRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                0);
        Assertions.assertEquals(
                0, account.getRate());
    }

    @Test
    public void shouldThrowExceptionForNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    -1_000,
                    5_000,
                    15);
        });
    }

    @Test
    public void shouldNotChangeBalanceIfPayIsFailed() {
        CreditAccount account = new CreditAccount(
                0,
                1_000,
                15);
        account.pay(
                5_000);
        Assertions.assertEquals(0, account.getBalance());
    }
}