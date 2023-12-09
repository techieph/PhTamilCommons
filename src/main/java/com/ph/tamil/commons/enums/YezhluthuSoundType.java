package com.ph.tamil.commons.enums;

public enum YezhluthuSoundType {

    Kuril("குறில்", 1),
    Nedil("நெடில்", 2),
    Mei("மெய்", 0.5);

    String yezhluthuSoundTypeName;
    double yezhluthuMaathiraiLevel;

    YezhluthuSoundType(String yezhluthuSoundTypeName, double yezhluthuMaathiraiLevel) {
        this.yezhluthuMaathiraiLevel = yezhluthuMaathiraiLevel;
        this.yezhluthuSoundTypeName = yezhluthuSoundTypeName;
    }

    @Override
    public String toString() {
        return this.yezhluthuSoundTypeName;
    }

    public double getYezhluthuSoundLevel() {
        return this.yezhluthuMaathiraiLevel;
    }
}
