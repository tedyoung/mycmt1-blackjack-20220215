package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public Hand() {
    }

    Hand(List<Card> cards) {
        this.cards.addAll(cards);
    }

    void drawCardFrom(Deck deck) {
        // require Hand is "in progress" — still being played
        // require not Busted
        cards.add(deck.draw());
    }

    int value() {
        int handValue = cards
                .stream()
                .mapToInt(Card::rankValue)
                .sum();

        // does the hand contain at least 1 Ace?
        boolean hasAce = cards
                .stream()
                .anyMatch(card -> card.rankValue() == 1);

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce && handValue <= 11) {
            handValue += 10;
        }

        return handValue;
    }

    // relates ONLY to Dealer
    Card faceUpCard() {
        return cards.get(0);
    }

    void display() {
        System.out.println(cards.stream()
                                .map(Card::display)
                                .collect(Collectors.joining(
                                       ansi().cursorUp(6).cursorRight(1).toString())));
    }

    boolean isBusted() {
        return value() > 21;
    }

    // relates ONLY to Dealer
    boolean shouldDealerHit() {
        return value() <= 16;
    }

    // PROTOCOL: can't ask these questions until both hands are final

    boolean pushes(Hand dealerHand) {
        // require Hand is final
        return dealerHand.value() == value();
    }

    boolean beats(Hand dealerHand) {
        // require Hand is final
        return dealerHand.value() < value();
    }
}
