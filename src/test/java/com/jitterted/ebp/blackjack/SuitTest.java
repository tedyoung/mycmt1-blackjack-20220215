package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SuitTest {

    @Test
    public void heartsIsRed() throws Exception {
        assertThat(Suit.HEARTS.isRed())
                .isTrue();
    }

    @Test
    public void clubsIsNotRed() throws Exception {
        assertThat(Suit.CLUBS.isRed())
                .isFalse();
    }

}