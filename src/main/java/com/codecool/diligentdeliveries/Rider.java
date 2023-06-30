package com.codecool.diligentdeliveries;

import java.util.ArrayList;

public class Rider {
    private int id;
    private String name;
    private DeliveryService deliveryService;
    private ReattemptStrategy reattemptStrategy;
    private ReportGenerator reportGenerator;

    public Rider(int id, String name, DeliveryService deliveryService, ReattemptStrategy reattemptStrategy, ReportGenerator reportGenerator) {
        this.id = id;
        this.name = name;
        this.deliveryService = deliveryService;
        this.reattemptStrategy = reattemptStrategy;
        this.reportGenerator = reportGenerator;
    }

    public void addParcel(Parcel parcel) {
        deliveryService.addParcel(parcel);
    }

    public void startRoutine() {
        deliveryService.startRoutine();
        reportGenerator.generateReport(this);
    }

    public int getReattemptsLeft() {
        return reattemptStrategy.getReattemptsLeft();
    }
}
