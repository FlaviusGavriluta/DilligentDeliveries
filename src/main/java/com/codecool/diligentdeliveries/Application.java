package com.codecool.diligentdeliveries;

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
    }
}
