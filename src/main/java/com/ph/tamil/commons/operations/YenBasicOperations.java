package com.ph.tamil.commons.operations;

import com.ph.tamil.commons.types.Yen;

public class YenBasicOperations {

    Yen yen;

    YenBasicOperations(Yen yen) {
        this.yen = yen;
    }

    public YenBasicOperations kootal(Yen otherYen) {
        this.yen = new Yen(this.yen.toInt() + otherYen.toInt());
        return this;
    }

    public YenBasicOperations kalithal(Yen otherYen) {
        this.yen = new Yen(this.yen.toInt() - otherYen.toInt());
        return this;
    }

    public YenBasicOperations peruthal(Yen otherYen) {
        this.yen =  new Yen(this.yen.toInt() * otherYen.toInt());
        return this;
    }

    public YenBasicOperations vaguthal(Yen otherYen) {
        this.yen = new Yen(this.yen.toInt() / otherYen.toInt());
        return this;
    }

    public Yen end() {
        return this.yen;
    }

}
