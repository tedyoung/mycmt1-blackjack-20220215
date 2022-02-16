package com.jitterted.ebp.blackjack;

public class Wallet {

    private int balance;

    public Wallet() {
        balance = 0;
    }

    public boolean isEmpty() {
        return balance == 0;
    }

    public void addMoney(int amount) {
        requireNonZeroAmount(amount);
        balance += amount;
    }

    public int balance() {
        return balance;
    }

    private void requireNonZeroAmount(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException();
        }
    }

}

