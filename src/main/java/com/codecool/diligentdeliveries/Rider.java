package com.codecool.diligentdeliveries;

import java.util.ArrayList;

public class Rider {
    private int id;
    private String name;
    private int reattemptPerAddress;
    private int maximumReattempts;
    private ArrayList<Parcel> parcels;
    private Report report;

    public Rider(int id, int reattemptPerAddress, int maximumReattempts) {
        this.id = id;
        this.reattemptPerAddress = reattemptPerAddress;
        this.maximumReattempts = maximumReattempts;
        this.parcels = new ArrayList<>();
        this.report = new Report(0, maximumReattempts);
    }

    public void addParcels(ArrayList<Parcel> parcels) {
        this.parcels.addAll(parcels);
    }

    public void startRoutine() {
        for (Parcel parcel : parcels) {
            boolean deliverySuccessful = parcel.deliver();
            if (!deliverySuccessful) {
                boolean reattemptSuccessful = reattempt(parcel);
                if (!reattemptSuccessful) {
                    handleFailedDelivery();
                }
            }
            handleSuccessfulDelivery(parcel);
        }
    }

    private boolean reattempt(Parcel parcel) {
        if (report.getReattemptsLeft() > 0) {
            report.decrementReattemptsLeft();
            return parcel.deliver();
        }
        return false;
    }

    private void handleSuccessfulDelivery(Parcel parcel) {
        if (parcel.deliver()) {
            report.incrementSuccessfulDeliveries();
        }
    }

    private void handleFailedDelivery() {
        // Additional logic for handling failed delivery
    }

    public Report getReport() {
        return report;
    }
}
