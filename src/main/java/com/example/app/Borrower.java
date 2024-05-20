package com.example.app;

public class Borrower implements User {
    private String id;
    private String name;
    private String lastName;

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
        System.out.println("Comment added by Borrower: " + comment);
    }

    public void rentVehicle(Vehicle vehicle) {
        System.out.println("Vehicle rented: " + vehicle.getModel());
    }

    public void returnVehicle(Vehicle vehicle) {
        System.out.println("Vehicle returned: " + vehicle.getModel());
    }
}