package com.example.app;

import java.util.ArrayList;
import java.util.List;

public class Lender implements User {
    private String id;
    private String name;
    private String lastName;
    private List<Vehicle> ownedCars = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void addComment(String comment) {
        System.out.println("Comment added by Lender: " + comment);
    }

    public void addVehicleToSystem(Vehicle vehicle) {
        ownedCars.add(vehicle);
        System.out.println("Vehicle added to system: " + vehicle.getModel());
    }
}