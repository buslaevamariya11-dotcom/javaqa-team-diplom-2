package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {


    //проверки конструктора SavingAccount

    @Test
    public void shouldNotLetRateLessThanZero() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -3
            );
        });
    }

    @Test
    public void shouldNotLetMinBalanceBeBiggerThanMax() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    15_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void shouldNotLetInitialBalanceBeLessThanMin() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    500,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void shouldLetInitialBalanceBeEqualToMin() {

        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        int expectedBalance = 1000;
        int actualBalance = account.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldNotLetInitialBalanceBeBiggerThanMax() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    15_000,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void shouldLetInitialBalanceBeEqualToMax() {

        SavingAccount account = new SavingAccount(
                10_000,
                1_000,
                10_000,
                5
        );

        int expectedBalance = 10_000;
        int actualBalance = account.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldLetInitialBalanceBeBetweenMinAndMax() {

        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        int expectedBalance = 5000;
        int actualBalance = account.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }



    // проверки метода add
    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldNotAddZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        boolean expected = false;
        boolean actual = account.add(0);

        Assertions.assertEquals(expected, actual);

        int expectedBalance = 2_000;
        int actualBalance = account.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldNotAddLessThanZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        boolean expected = false;
        boolean actual = account.add(-10);

        Assertions.assertEquals(expected, actual);

        int expectedBalance = 2_000;
        int actualBalance = account.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldNotAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        boolean expected = false;
        boolean actual = account.add(15_000);

        Assertions.assertEquals(expected, actual);

        int expectedBalance = 2_000;
        int actualBalance = account.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldLetAddEqualMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        boolean expected = true;
        boolean actual = account.add(8_000);

        Assertions.assertEquals(expected, actual);

    }


    // проверки метода pay
    @Test
    public void shouldPayWithBalanceLeftMoreThanMin() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        account.pay(800);

        Assertions.assertEquals(2_000 - 800, account.getBalance());
    }

    @Test
    public void shouldNotLetPayWithBalanceLeftLessThanMin() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        boolean expected = false;
        boolean actual = account.pay(1_500);

        Assertions.assertEquals(expected, actual);

        int expectedBalance = 2_000;
        int actualBalance = account.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldLetPayWithBalanceLeftEqualMin() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        boolean expected = true;
        boolean actual = account.pay(1_000);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotLetPayLessThanZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        boolean expected = false;
        boolean actual = account.pay(-1000);

        Assertions.assertEquals(expected, actual);

        int expectedBalance = 2_000;
        int actualBalance = account.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldNotLetPayZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        boolean expected = false;
        boolean actual = account.pay(0);

        Assertions.assertEquals(expected, actual);

        int expectedBalance = 2_000;
        int actualBalance = account.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

// проверки метода yearChange

    @Test

    public void shouldShowPercentForBalance() {
        SavingAccount account = new SavingAccount(
                783,
                50,
                10_000,
                5
        );

        Assertions.assertEquals(39, account.yearChange());

    }
}
