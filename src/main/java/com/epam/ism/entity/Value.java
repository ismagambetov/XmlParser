package com.epam.ism.entity;


/**
 * Created by Damir Ismagambetov.
 */
public class Value {
    private String value;

    public Value(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
