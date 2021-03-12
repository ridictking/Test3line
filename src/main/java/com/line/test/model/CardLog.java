package com.line.test.model;

import java.time.LocalDateTime;

public class CardLog extends Card {
    private final LocalDateTime time;

    public CardLog(String scheme, String type, String bank, String cardNumber, LocalDateTime time) {
        super(scheme, type, bank, cardNumber);
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
