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
        //Implement
    }

    public void startRoutine() {
        //Implement
    }

    private boolean reattempt(Parcel parcel) {
        //Implement
        return false;
    }

    private void handleSuccessfulDelivery(Parcel parcel) {
        //Implement
    }

    public Report getReport() {
        //Implement
        return null;
    }
}
