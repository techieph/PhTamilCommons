package com.ph.tamil.commons.enums;

public enum YezhluthuConstantType {

    Vallinam("வல்லினம்"),
    Mellinam("மெல்லினம்"),
    Idaiyinam("இடையினம்"),
    NotApplicable("பொருந்தாது");

    private final String yezhluthuConstantType;

    YezhluthuConstantType(String yezhluthuConstantType) {
        this.yezhluthuConstantType = yezhluthuConstantType;
    }

    public String toString() {
        return this.yezhluthuConstantType;
    }
}
