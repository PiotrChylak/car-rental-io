package com.example.app.model;

import com.example.app.IDGenerator;

public class Motorcycle extends Vehicle {

    public Motorcycle(String brand, String model, String plate, String id, int year, float dailyFee, String ownerId) {
        if(id == null)
            this.id = IDGenerator.generateVehicleID("M");
        else
            this.id = id;
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.brand = brand;
        // this.category = "B1";
        this.isRented = false;
        this.ownerId = ownerId;
        this.dailyFee = dailyFee;
    }
}