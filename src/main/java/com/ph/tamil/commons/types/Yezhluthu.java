package com.ph.tamil.commons.types;

import com.ph.tamil.commons.constants.TypesConstant;
import com.ph.tamil.commons.data.AsciiYezhluthuMapSupplier;
import com.ph.tamil.commons.data.YezhluthuDetailsData;
import com.ph.tamil.commons.exception.InvalidYezhluthuException;
import com.ph.tamil.commons.model.YezhluthuDetails;

public class Yezhluthu implements Comparable<Yezhluthu> {

    int yezhluthuIndex;

    public Yezhluthu(char ch) throws InvalidYezhluthuException {
        this(Character.toString(ch));
    }

    public Yezhluthu(String string) throws InvalidYezhluthuException {
        if(string.isEmpty() || string.length() > 2) {
            throw new InvalidYezhluthuException();
        }
        String key = (int) string.charAt(0) + (string.length() == 2 ? "-" + (int) string.charAt(1) : "");
        if(AsciiYezhluthuMapSupplier.getAsciiYezhluthuMapSupplier().get().containsKey(key)){
            yezhluthuIndex = AsciiYezhluthuMapSupplier.getAsciiYezhluthuMapSupplier().get().get(key);
        } else {
            throw new InvalidYezhluthuException();
        }
    }

    public Yezhluthu(int yezhluthuIndex) throws InvalidYezhluthuException {
        if(yezhluthuIndex<= TypesConstant.YezhluthuIndexMaxNumber && yezhluthuIndex >= TypesConstant.YezhluthuIndexMinNumber){
            this.yezhluthuIndex = yezhluthuIndex;
        } else {
            throw new InvalidYezhluthuException();
        }
    }

    public String toString() {
        return YezhluthuDetailsData.getYezhluthuDetails.apply(yezhluthuIndex).getYezhluthuString();
    }

    public YezhluthuDetails getYezhluthuDetails() {
        return YezhluthuDetailsData.getYezhluthuDetails.apply(yezhluthuIndex);
    }

    @Override
    public int compareTo(Yezhluthu o) {
        return yezhluthuIndex - o.yezhluthuIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Yezhluthu yezhluthu = (Yezhluthu) o;
        return yezhluthuIndex == yezhluthu.yezhluthuIndex;
    }
}
