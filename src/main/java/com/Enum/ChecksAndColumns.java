package com.Enum;

public enum ChecksAndColumns
{

    CHECK_NAME,
    COLUMN_NAME;

    public String value;

    public void setValue(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }

}
