package com.codecool.diligentdeliveries;

import java.util.List;
import java.util.Random;

public class ReattemptStrategy {
    private int reattemptsLeft;
    private List<String> reattemptLocations;
    private Random random;
    private Parcel parcel;

    public ReattemptStrategy(List<String> reattemptLocations) {
        this.reattemptLocations = reattemptLocations;
        this.random = new Random();
    }

    public void chooseReattemptLocation(Parcel parcel) {
        int locationIndex = random.nextInt(reattemptLocations.size());
        String chosenLocation = reattemptLocations.get(locationIndex);
        parcel.setReattemptLocation(chosenLocation);
    }

    public int getReattemptsLeft() {
        return reattemptsLeft;
    }
}
