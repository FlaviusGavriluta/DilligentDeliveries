package com.codecool.diligentdeliveries;

import java.util.List;

public class DeliverySimulation {
    public static void runSimulation(List<Rider> riders, int rounds) {
        for (int i = 0; i < rounds; i++) {
            for (Rider rider : riders) {
                rider.startRoutine();
            }
        }
    }

    public static Rider selectBestRider(List<Rider> riders) {
        Rider bestRider = riders.get(0); // Assume the first rider is the best initially

        for (int i = 1; i < riders.size(); i++) {
            Rider currentRider = riders.get(i);
            int totalDeliveriesCurrent = currentRider.getSuccessfulDeliveries();
            int totalDeliveriesBest = bestRider.getSuccessfulDeliveries();

            if (totalDeliveriesCurrent > totalDeliveriesBest) {
                bestRider = currentRider; // Update the best rider if a better one is found
            }
        }
        return bestRider;
    }

    public static void printSummary(Rider bestRider) {
        System.out.println("Summary:");
        System.out.println("Best Rider: " + Rider.getName(bestRider));
        System.out.println("Total Deliveries: " + bestRider.getSuccessfulDeliveries());
    }
}