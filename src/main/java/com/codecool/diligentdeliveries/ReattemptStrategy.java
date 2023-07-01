package com.codecool.diligentdeliveries;

public class ReattemptStrategy {
    private int reattemptsLeft;
    private Parcel parcel;

    public ReattemptStrategy() {
        reattemptsLeft = 0;
    }

    public void chooseReattemptLocation(Parcel parcel) {

    }

    public int getReattemptsLeft() {
        return reattemptsLeft;
    }
}
