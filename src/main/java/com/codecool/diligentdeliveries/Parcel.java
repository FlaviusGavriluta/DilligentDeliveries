package com.codecool.diligentdeliveries;

public class Parcel {
    private int id;
    private Address address;

    public Parcel(int id, Address address) {
        this.id = id;
        this.address = address;
    }

    public boolean deliver() {
        // Implementation for delivery logic
        // Return true if the delivery is successful, at least 50% of the time
        // You can use randomization for this
        return false;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id=" + id +
                ", address=" + address +
                '}';
    }
}
