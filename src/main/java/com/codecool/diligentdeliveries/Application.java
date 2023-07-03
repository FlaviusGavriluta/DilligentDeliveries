package com.codecool.diligentdeliveries;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        ReportGenerator reportGenerator = new ReportGenerator();
        List<String> reattemptLocations = Arrays.asList("Location1", "Location2", "Location3", "Location4", "Location5");
        List<ReattemptStrategy> reattemptStrategies = Arrays.asList(
                new ReattemptStrategy(reattemptLocations),
                new ReattemptStrategy(reattemptLocations),
                new ReattemptStrategy(reattemptLocations)
        );

        List<Rider> riders = new ArrayList<>();
        DeliveryService deliveryService = new DeliveryService();

        for (int i = 0; i < reattemptStrategies.size(); i++) {
            ReattemptStrategy reattemptStrategy = reattemptStrategies.get(i);
            Rider rider = new Rider(i + 1, "Rider " + (i + 1), deliveryService, reattemptStrategy, reportGenerator);
            riders.add(rider);
        }
        int rounds = 1000;
        DeliverySimulation.runSimulation(riders, rounds);
        Rider bestRider = DeliverySimulation.selectBestRider(riders);
        DeliverySimulation.printSummary(bestRider);
    }
}
