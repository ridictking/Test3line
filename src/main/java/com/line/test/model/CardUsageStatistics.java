package com.line.test.model;

import java.util.HashMap;

public class CardUsageStatistics {
    private boolean success;
    private int start;
    private int limit;
    private int size;
    private HashMap<String, Long> payload;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public HashMap<String, Long> getPayload() {
        return payload;
    }

    public void setPayload(HashMap<String, Long> payload) {
        this.payload = payload;
    }
}
