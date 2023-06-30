package com.codecool.diligentdeliveries;

import java.util.Random;

public class Parcel {
    private int id;
    private Address address;
    private static final Random random = new Random();

    public Parcel(int id, Address address) {
        this.id = id;
        this.address = address;
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
}
