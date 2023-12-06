package com.ph.tamil.commons.enums;

public enum YezhluthuSoundType {

    Kuril("குறில்", 1),
    Nedil("நெடில்", 2),
    Mei("மெய்", 0.5);

    String yezhluthuSoundTypeName;
    double yezhluthuSoundTypeLevel;

    YezhluthuSoundType(String yezhluthuSoundTypeName, double yezhluthuSoundTypeLevel) {
        this.yezhluthuSoundTypeLevel = yezhluthuSoundTypeLevel;
        this.yezhluthuSoundTypeName = yezhluthuSoundTypeName;
    }

    @Override
    public String toString() {
        return this.yezhluthuSoundTypeName;
    }

    public double getYezhluthuSoundTypeLevel() {
        return this.yezhluthuSoundTypeLevel;
    }
}
