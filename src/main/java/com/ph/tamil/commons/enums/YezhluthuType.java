package com.ph.tamil.commons.enums;

public enum YezhluthuType {
    Uyir("உயிர்"),
    Mei("மெய்"),
    UyirMei("உயிர்மெய்"),
    Aayutham("ஆயுதம்");

    private final String yezhluthuType;

    YezhluthuType(String yezhluthuType) {
        this.yezhluthuType = yezhluthuType;
    }

    public String toString() {
        return this.yezhluthuType;
    }
}
