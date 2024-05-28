package com.example.app.model;

import com.example.app.IDGenerator;

public class Borrower implements User {
    private String id;
    public String username;
    private String name;
    private String lastName;
    public String password;
    public float moneyBalance;
    public Enum<ROLES> role = ROLES.USER;
    public String rentedVehicleID = null;

    public Borrower(String name, String lastName, String username, String password, String id, float moneyBalance) {
        if(id == null)
            this.id = IDGenerator.generateUserID("B");
        else
            this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.moneyBalance = moneyBalance;
    }
    //TODO: add rented vehicle to user
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

    @Override
    public float getBalance() {
        return moneyBalance;
    }
    public void setBalance(float balance){
        moneyBalance = balance;
    }

    public void addComment(String comment) {
        System.out.println("Comment added by Borrower: " + comment);
    }

    public String toCSV(){
        return this.id + "," + this.name + "," + this.lastName + "," + this.username + "," + this.password + "," + this.moneyBalance + "," + this.role + "," + this.rentedVehicleID;
    }
}