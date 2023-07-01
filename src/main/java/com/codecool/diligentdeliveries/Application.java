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
        List<String> reattemptLocations = Arrays.asList("Location1", "Location2", "Location3", "Location4", "Location5");
        ReattemptStrategy reattemptStrategy = new ReattemptStrategy(reattemptLocations);
        DeliveryService deliveryService = new DeliveryService(reattemptStrategy);
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
