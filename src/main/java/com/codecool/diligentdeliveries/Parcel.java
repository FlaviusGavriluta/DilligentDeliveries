package com.codecool.diligentdeliveries;

import java.util.Random;

public class Parcel {
    private int id;
    private int reattemptsLeft;
    private int maximumReattempts;
    private Address address;
    private static final Random random = new Random();

    public Parcel(int id, Address address) {
        this.id = id;
        this.address = address;
        maximumReattempts = 5;
        reattemptsLeft = maximumReattempts;
    }

    public boolean deliver() {
        int successRate = random.nextInt(51) + 50;
        boolean deliverySuccessful = random.nextInt(100) < successRate;
        return deliverySuccessful;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id=" + id +
                ", address=" + address +
                '}';
    }

    public int getReattemptsLeft() {
        return reattemptsLeft;
    }
}
