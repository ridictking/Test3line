package com.line.test.model;

public class CardVerificationResponse {
    private boolean success;
    private Card payload;

    public CardVerificationResponse(boolean success, Card payload) {
        this.success = success;
        this.payload = payload;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Card getPayload() {
        return payload;
    }

    public void setPayload(Card payload) {
        this.payload = payload;
    }
}
