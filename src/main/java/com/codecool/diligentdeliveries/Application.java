package com.codecool.diligentdeliveries;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {
    private static final Random random = new Random();

    private static String getRandomStreetAddress() {
        return "Random Street "
                + random.nextInt(100, 1000)
                + " Number " + random.nextInt(0, 100);
    }

    public static void main(String[] args) {
        int packages = 10;
        int maximumReattempts = 5;
        ReportGenerator reportGenerator = new ReportGenerator();

        List<String> reattemptLocations = Arrays.asList("Location1", "Location2", "Location3", "Location4", "Location5");
        ReattemptStrategy reattemptStrategy = new ReattemptStrategy(reattemptLocations);
        DeliveryService deliveryService = new DeliveryService(reattemptStrategy);

        ReattemptStrategy reattemptStrategy1 = new ReattemptStrategy(reattemptLocations);
        Rider rider1 = new Rider(1, "Jonathan", deliveryService, reattemptStrategy1, reportGenerator);
        reportGenerator.generateReport(rider1);

        ReattemptStrategy reattemptStrategy2 = new ReattemptStrategy(reattemptLocations);
        Rider rider2 = new Rider(2, "Jayson", deliveryService, reattemptStrategy2, reportGenerator);
        reportGenerator.generateReport(rider2);

        ReattemptStrategy reattemptStrategy3 = new ReattemptStrategy(reattemptLocations);
        Rider rider3 = new Rider(3, "Evan", deliveryService, reattemptStrategy3, reportGenerator);
        reportGenerator.generateReport(rider3);

        rider1.startRoutine();
        rider2.startRoutine();
        rider3.startRoutine();

        Rider bestRider = selectBestRider(rider1, rider2, rider3);
        printSummary(bestRider);
    }

    private static Rider selectBestRider(Rider rider1, Rider rider2, Rider rider3) {
        int totalDeliveries1 = rider1.getSuccessfulDeliveries();
        int totalDeliveries2 = rider2.getSuccessfulDeliveries();
        int totalDeliveries3 = rider3.getSuccessfulDeliveries();

        if (totalDeliveries1 >= totalDeliveries2 && totalDeliveries1 >= totalDeliveries3) {
            return rider1;
        } else if (totalDeliveries2 >= totalDeliveries1 && totalDeliveries2 >= totalDeliveries3) {
            return rider2;
        } else {
            return rider3;
        }
    }

    private static void printSummary(Rider bestRider) {
        System.out.println("Summary:");
        System.out.println("Best Rider: " + Rider.getName(bestRider));
        System.out.println("Total Deliveries: " + bestRider.getSuccessfulDeliveries());
    }

    private static String generateRandomAddress() {
        return "Random Street "
                + random.nextInt(100, 1000)
                + " Number " + random.nextInt(0, 100);
    }

    private static String generateRandomCustomerName() {
        List<String> customerNames = Arrays.asList("John", "Jane", "Mike", "Emily");
        int randomIndex = random.nextInt(customerNames.size());
        return customerNames.get(randomIndex);
    }
}
