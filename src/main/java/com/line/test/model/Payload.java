package com.line.test.model;

import java.util.HashMap;

public class Payload {
    private HashMap<String, Long> record;

    public HashMap<String, Long> getRecord() {
        return record;
    }

    public void setRecord(HashMap<String, Long> record) {
        this.record = record;
    }
}
