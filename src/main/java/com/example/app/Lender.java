package com.example.app;

import java.util.ArrayList;
import java.util.List;

public class Lender implements User {
    private String id;
    private String name;
    private String lastName;
    public String username;
    public String password;
    public int moneyBalance = 0;
    public Enum<ROLES> role = ROLES.USER;
    public List<Vehicle> ownedCars = new ArrayList<>();
    public Lender(String name, String lastName, String username, String password) {
        this.id = IDGenerator.generateID("L");
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
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
    public String toCSV() {
        return id + "," + name + "," + lastName + "," + username + "," + password + "," + moneyBalance + "," + role;
    }
}