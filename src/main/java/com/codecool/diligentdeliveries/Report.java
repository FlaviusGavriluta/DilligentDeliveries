package com.codecool.diligentdeliveries;

public class Report {
    private int successfulDeliveries;
    private int reattemptsLeft;

    public Report(int successfulDeliveries, int reattemptsLeft) {
        this.successfulDeliveries = successfulDeliveries;
        this.reattemptsLeft = reattemptsLeft;
    }

    @Override
    public String toString() {
        return "Report{" +
                "successfulDeliveries=" + successfulDeliveries +
                ", reattemptsLeft=" + reattemptsLeft +
                '}';
    }
}
