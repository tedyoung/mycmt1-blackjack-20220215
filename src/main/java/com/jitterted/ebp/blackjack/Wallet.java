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
        requireGreaterThanZero(amount);
        balance += amount;
    }

    public int balance() {
        return balance;
    }

    // this command COULD throw an exception due to the (hidden?) STATE of object
    // therefore, have a "can I do this?" Query method
    // e.g.: boolean canBet(betAmount)?
    public void bet(int betAmount) {
        requireSufficientBalanceToBet(betAmount);
        balance -= betAmount;
    }

    private void requireSufficientBalanceToBet(int betAmount) {
        if (betAmount > balance) {
            throw new IllegalStateException();
        }
    }

    private void requireGreaterThanZero(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
    }
}

