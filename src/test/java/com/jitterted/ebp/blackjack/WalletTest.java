package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

    @Test
    public void newWalletIsEmpty() throws Exception {
        // GIVEN a wallet, WHEN it's new
        Wallet wallet = new Wallet();

        // THEN it is Empty
        assertThat(wallet.isEmpty())
                .isTrue();
    }

    @Test
    public void newWalletWhenAddMoneyIsNotEmpty() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(1);

        assertThat(wallet.isEmpty())
                .isFalse();
    }

    @Test
    public void newWalletHasZeroBalance() throws Exception {
        Wallet wallet = new Wallet();

        assertThat(wallet.balance())
                .isZero();
    }

    @Test
    public void newWalletAdd7ThenBalanceIs7() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(7);

        assertThat(wallet.balance())
                .isEqualTo(7);
    }

    @Test
    public void newWalletAdd10AndAdd5ThenBalanceIs15() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(10);
        wallet.addMoney(5);

        assertThat(wallet.balance())
                .isEqualTo(10 + 5);
    }

    @Test
    public void addMoneyOfZeroThrowsException() throws Exception {
        Wallet wallet = new Wallet();

        assertThatThrownBy(() -> {
            wallet.addMoney(0);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void addMoneyOfNegativeAmountThrowsException() throws Exception {
        Wallet wallet = new Wallet();

        assertThatThrownBy(() -> {
            wallet.addMoney(-1);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

}


