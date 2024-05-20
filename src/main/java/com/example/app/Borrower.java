package com.example.app;

public class Borrower implements User {
    private int id;
    public String username;
    private String name;
    private String lastName;
    public String password;
    public int moneyBalance = 0;
    public Enum<ROLES> role = ROLES.USER;
    public Vehicle rentedVehicle = null;

    public Borrower(String name, String lastName, String username, String password) {
        this.id = 0; // TODO: Implement ID generation
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    //TODO: add rented vehicle to user
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
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
    //TODO add rented vehicle to user
    public String toCSV(){
        return this.id + "," + this.name + "," + this.lastName + "," + this.username + "," + this.password + "," + this.moneyBalance + "," + this.role;
    }
}