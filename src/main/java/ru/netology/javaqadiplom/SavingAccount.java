package ru.netology.javaqadiplom;

/**
 * Сберегательный счёт
 */
public class SavingAccount extends Account {
    protected int minBalance;
    protected int maxBalance;

    public SavingAccount(int initialBalance, int minBalance, int maxBalance, int rate) {
        if (rate < 0) {
            throw new IllegalArgumentException(
                    "Накопительная ставка не может быть отрицательной, а у вас: " + rate
            );
        }
        if (minBalance < 0) {
            throw new IllegalArgumentException(
                    "Минимальный баланс не может быть отрицательным"
            );
        }
        if (minBalance > maxBalance) {
            throw new IllegalArgumentException(
                    "Минимальный баланс не может быть больше максимального"
            );
        }
        if (initialBalance < minBalance || initialBalance > maxBalance) {
            throw new IllegalArgumentException(
                    "Начальный баланс " + initialBalance + " вне диапазона допустимых значений"
            );
        }

        this.balance = initialBalance;
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
        this.rate = rate;
    }

    @Override
    public boolean pay(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance - amount >= minBalance) {
            balance = balance - amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance + amount <= maxBalance) {
            balance = balance + amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int yearChange() {
        return balance * rate / 100;
    }

    public int getMinBalance() {
        return minBalance;
    }

    public int getMaxBalance() {
        return maxBalance;
    }
}