package com.ph.tamil.commons.types;

import com.ph.tamil.commons.exception.InvalidYezhluthuException;

import java.util.ArrayList;
import java.util.List;

public class Sol implements Comparable<Sol> {

    List<Yezhluthu> yezhluthuList= new ArrayList<>();

    Sol(Yezhluthu[] yezhluthukal) {
        yezhluthuList.addAll(List.of(yezhluthukal));
    }

    Sol(List<Yezhluthu> yezhluthuList) {
        this.yezhluthuList = yezhluthuList;
    }
    
    Sol(char ch) throws InvalidYezhluthuException {
        new Sol(Character.toString(ch));
    }

    public Sol(String string) throws InvalidYezhluthuException {
        for(int i=0;i<string.length();i++) {
            if(i==string.length()-1) {
                yezhluthuList.add(new Yezhluthu(string.charAt(i)));
            } else {
                try{
                    Yezhluthu yezhluthu = new Yezhluthu(string.charAt(i) + string.charAt(i+1));
                    yezhluthuList.add(yezhluthu);
                } catch (InvalidYezhluthuException e) {
                    yezhluthuList.add(new Yezhluthu(string.charAt(i)));
                }
            }
        }
    }

    public Sol subSol(int beginIndex, int endIndex) {
        return new Sol(yezhluthuList.subList(beginIndex, endIndex));
    }

    public Sol subSol(int beginIndex) {
        return new Sol(yezhluthuList.subList(beginIndex, this.yezhluthuList.size()));
    }

    public void replace(Yezhluthu oldYezhluthu, Yezhluthu newYezhluthu) {
        for (int i = 0; i < yezhluthuList.size(); i++) {
            if (yezhluthuList.get(i).equals(oldYezhluthu)) {
                yezhluthuList.set(i, newYezhluthu);
            }
        }
    }

    public int length() {
        return this.yezhluthuList.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Yezhluthu yezhluthu: this.yezhluthuList) {
            sb.append(yezhluthu.toString());
        }
        return sb.toString();
    }

    public boolean startsWith(Sol prefixSol) {
        String prefixSolString = prefixSol.toString();
        return this.toString().startsWith(prefixSolString);
    }

    public boolean endsWith(Sol suffixSol) {
        String suffixSolString = suffixSol.toString();
        return this.toString().endsWith(suffixSolString);
    }

    public int indexOf(Sol targetSol) {
        for (int i = 0; i <= yezhluthuList.size() - targetSol.yezhluthuList.size(); i++) {
            boolean found = true;
            for (int j = 0; j < targetSol.yezhluthuList.size(); j++) {
                if (!yezhluthuList.get(i + j).equals(targetSol.yezhluthuList.get(j))) {
                    found = false;
                    break;
                }
            }
            if (found) { return i; }
        }
        return -1;
    }

    @Override
    public int compareTo(Sol o) {
        List<Yezhluthu> otherYezhluthuList = o.yezhluthuList;
        int minLength = Math.min(yezhluthuList.size(), otherYezhluthuList.size());
        for (int i = 0; i < minLength; i++) {
            int comparison = yezhluthuList.get(i).compareTo(otherYezhluthuList.get(i));
            if (comparison != 0) {
                return comparison;
            }
        }
        // If the common prefix is the same, the shorter list comes first
        return Integer.compare(yezhluthuList.size(), otherYezhluthuList.size());
    }
}
