package com.example.app;

public class Motorcycle extends Vehicle {
    private String category;

    public Motorcycle(String model, int year, String plate, String brand, String category,int dailyfee,String ownerId) {
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.brand = brand;
        this.category = category;
        this.isRented = false;
        this.ownerId = ownerId;
        this.dailyFee = dailyfee;
    }

    public String getCategory() {
        return category;
    }
}