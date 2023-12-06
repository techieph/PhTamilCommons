package com.ph.tamil.commons.model;

import com.ph.tamil.commons.enums.YezhluthuConstantType;
import com.ph.tamil.commons.enums.YezhluthuSoundType;
import com.ph.tamil.commons.enums.YezhluthuType;


public class YezhluthuDetails {

    String yezhluthuString;
    String hashString;
    YezhluthuSoundType yezhluthuSoundType;
    YezhluthuType yezhluthuType;
    YezhluthuConstantType yezhluthuConstantType;

    public YezhluthuDetails(String yezhluthuString, String hashString, YezhluthuSoundType yezhluthuSoundType, YezhluthuType yezhluthuType, YezhluthuConstantType yezhluthuConstantType) {
        this.yezhluthuString = yezhluthuString;
        this.hashString = hashString;
        this.yezhluthuSoundType = yezhluthuSoundType;
        this.yezhluthuType = yezhluthuType;
        this.yezhluthuConstantType = yezhluthuConstantType;
    }

    public String getYezhluthuString() {
        return yezhluthuString;
    }

    public String getHashString() {
        return hashString;
    }

    public YezhluthuSoundType getYezhluthuSoundType() {
        return yezhluthuSoundType;
    }

    public YezhluthuType getYezhluthuType() {
        return yezhluthuType;
    }

    public YezhluthuConstantType getYezhluthuConstantType() {
        return yezhluthuConstantType;
    }

    @Override
    public String toString() {
        return "YezhluthuDetails{" +
                "yezhluthuString='" + yezhluthuString + '\'' +
                ", yezhluthuSoundType=" + yezhluthuSoundType +
                ", yezhluthuType=" + yezhluthuType +
                ", yezhluthuConstantType=" + yezhluthuConstantType +
                ", hashString='" + hashString + '\'' +
                '}';
    }
}
