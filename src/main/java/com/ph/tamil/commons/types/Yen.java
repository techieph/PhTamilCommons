package com.ph.tamil.commons.types;

import com.ph.tamil.commons.constants.TypesConstant;
import com.ph.tamil.commons.exception.InvalidYenException;

import java.util.Arrays;
import java.util.Objects;

public class Yen implements Comparable<Yen> {

    char[] chars;
    boolean isPositiveNumber = true;

    public Yen(char character) throws InvalidYenException {
        new Yen(Character.toString(character));
    }

    public Yen(String string) throws InvalidYenException {
        if(string.isBlank() || string.isEmpty()) {
            throw new InvalidYenException("String is Empty");
        }
        if(string.charAt(0)=='-'||string.charAt(0)=='+') {
            this.isPositiveNumber = !(string.charAt(0)=='-');
            string = string.substring(1);
        }
        if(string.isBlank() || string.isEmpty()) {
            throw new InvalidYenException("String is Empty");
        }
        if(string.length() > TypesConstant.YenMaxSize) {
            throw new InvalidYenException("String exceeded maximum yen size");
        }
        chars = new char[TypesConstant.YenMaxSize];
        Arrays.fill(chars, (char) TypesConstant.YenReferenceCharacter);
        for(int i=0;i<string.length();i++) {
            if(string.charAt(i)<=TypesConstant.YenMaximumDecimalNumber && string.charAt(i)>=TypesConstant.YenMinimumDecimalNumber) {
                chars[TypesConstant.YenMaxSize-string.length()+i] = (char) ((int) string.charAt(i) - TypesConstant.YenMinimumDecimalNumber + TypesConstant.YenReferenceCharacter);
            } else {
                System.out.println(string.charAt(i) + " " + (int) string.charAt(i) );
                throw new InvalidYenException();
            }
        }
    }

    public Yen(int number) {
        if(number < 0) {
            this.isPositiveNumber = false;
            number *= -1;
        }
        int i=0;
        chars = new char[TypesConstant.YenMaxSize];
        Arrays.fill(chars, (char) TypesConstant.YenReferenceCharacter);
        while(number!=0){
            chars[TypesConstant.YenMaxSize - ++i] = (char) (number%10 + TypesConstant.YenReferenceCharacter);
            number/=10;
        }
    }

    public String toString() {
        boolean isTrailingZero = true;
        StringBuilder sb = new StringBuilder();
        if(!this.isPositiveNumber) {
            sb.append('-');
        }
        for (char ch : chars) {
            if (!isTrailingZero || ch > TypesConstant.YenReferenceCharacter) {
                sb.append((char) (ch - TypesConstant.YenReferenceCharacter + TypesConstant.YenMinimumDecimalNumber));
                isTrailingZero = false;
            }
        }
        return sb.toString().isEmpty() ? Character.toString(TypesConstant.YenMinimumDecimalNumber) : sb.toString();
    }

    public int toInt() {
        int number = 0;
        for(int i=0;i<TypesConstant.YenMaxSize;i++) {
            number *= 10;
            number += (chars[i] - TypesConstant.YenReferenceCharacter);
        }
        return this.isPositiveNumber ? number : number*-1;
    }

    @Override
    public int compareTo(Yen o) {
        return this.toInt() - o.toInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Yen yen = (Yen) o;
        return this.toInt() == yen.toInt();
    }

}
