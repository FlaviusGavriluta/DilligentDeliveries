package com.codecool.diligentdeliveries;

import java.util.*;

public class DeliverySimulation {
    public static void runSimulation(List<Rider> riders, int rounds) {
        for (int i = 0; i < rounds; i++) {
            for (Rider rider : riders) {
                rider.startRoutine();
            }
        }
    }

    public static Rider selectBestRider(List<Rider> riders) {
        return riders.stream()
                .max(Comparator.comparingInt(Rider::getSuccessfulDeliveries))
                .orElse(null);
    }

    public static void printSummary(Rider bestRider) {
        System.out.println("Summary:");
        System.out.println("Best Rider: " + Rider.getName(bestRider));
        System.out.println("Total Deliveries: " + bestRider.getSuccessfulDeliveries());
    }
}