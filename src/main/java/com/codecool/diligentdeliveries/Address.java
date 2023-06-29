package com.codecool.diligentdeliveries;

public class Address {
    private String zipCode;
    private String streetAddress;
    private String customerName;

    public Address(String zipCode, String streetAddress, String customerName) {
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
        this.customerName = customerName;
    }

    // Getters and Setters
    @Override
    public String toString() {
        return "Address{" +
                "zipCode='" + zipCode + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
