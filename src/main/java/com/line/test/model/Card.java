package com.line.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Card {
    private final String scheme;
    private final String type;
    private final String bank;
    @JsonIgnore
    private final String cardNumber;

    public Card(String scheme, String type, String bank, String cardNumber) {
        this.scheme = scheme;
        this.type = type;
        this.bank = bank;
        this.cardNumber = cardNumber;
    }

    public String getScheme() {
        return scheme;
    }

    public String getType() {
        return type;
    }

    public String getBank() {
        return bank;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
