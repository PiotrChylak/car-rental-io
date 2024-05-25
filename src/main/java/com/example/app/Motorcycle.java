package com.example.app;

public class Motorcycle extends Vehicle {
    private String category;

    public Motorcycle(String model, int year, String plate, String brand, String category,float dailyFee,String ownerId, String id) {
        if(id == null)
            this.id = IDGenerator.generateVehicleID("M");
        else
            this.id = id;
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.brand = brand;
        this.category = category;
        this.isRented = false;
        this.ownerId = ownerId;
        this.dailyFee = dailyFee;
    }

    public String getCategory() {
        return category;
    }
}