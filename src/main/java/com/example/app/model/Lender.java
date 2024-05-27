package com.example.app.model;

import java.util.ArrayList;
import java.util.List;

import com.example.app.IDGenerator;

public class Lender implements User {
    private String id;
    private String name;
    private String lastName;
    public String username;
    public String password;
    public float moneyBalance = 0;
    public Enum<ROLES> role = ROLES.USER;
    public List<Vehicle> ownedCars = new ArrayList<>();
    public Lender(String name, String lastName, String username, String password, String id, float moneyBalance) {
        if(id == null)
            this.id = IDGenerator.generateUserID("L");
        else
            this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.moneyBalance = moneyBalance;
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
    public float getBalance(){
        return moneyBalance;
    }
    public void setBalance(float amount){
        moneyBalance = amount;
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

    public void addVehicle(Vehicle vehicle) {
        ownedCars.add(vehicle);
        System.out.println("Vehicle added: " + vehicle.getModel());
    }
    public String toCSV() {
        return this.id + "," + this.name + "," + this.lastName + "," + this.username + "," + password + "," + moneyBalance + "," + role;
    }

    public boolean confirmRentRequest(Borrower loggedUser, Vehicle vehicle) {
        return true;
    }
}