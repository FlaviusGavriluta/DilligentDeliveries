package com.codecool.diligentdeliveries;

import java.util.ArrayList;

public class DeliveryService {
    private ArrayList<Parcel> parcels;
    private int successfulDeliveries;
    private ReattemptStrategy reattemptStrategy;

    public DeliveryService() {
        parcels = new ArrayList<>();
        successfulDeliveries = 0;
        this.reattemptStrategy = reattemptStrategy;
    }

    public void addParcel(Parcel parcel) {
        parcels.add(parcel);
    }

    public void startRoutine() {
        for (Parcel parcel : parcels) {
            attemptDelivery(parcel);
        }
    }

    private void attemptDelivery(Parcel parcel) {
        if (parcel.deliver()) {
            successfulDeliveries++;
        } else {
            reattempt(parcel);
        }
    }

    public int getReattemptsLeft() {
        int reattemptsLeft = 0;
        for (Parcel parcel : parcels) {
            reattemptsLeft += parcel.getReattemptsLeft();
        }
        return reattemptsLeft;
    }

    private void reattempt(Parcel parcel) {
        if (parcel.getReattemptsLeft() > 0) {
            reattemptStrategy.chooseReattemptLocation(parcel);
            attemptDelivery(parcel);
        }
    }

}
