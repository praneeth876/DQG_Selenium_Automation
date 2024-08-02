package com.Enum;

public enum Context {

    CONNECTION_NAME,
    TABLE_NAME,
    RULE_NAME,
    LANGUAGE,

    EXECUTION;

    public String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
