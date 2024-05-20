package com.example.app;

public class Borrower implements User {
    private String id;
    public String username;
    private String name;
    private String lastName;
    public String password;
    public int moneyBalance = 0;
    public Enum<ROLES> role = ROLES.USER;
    public Vehicle rentedVehicle = null;

    public Borrower(String name, String lastName, String username, String password) {
        this.id = IDGenerator.generateID("B");
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

    //TODO add rented vehicle to user
    public String toCSV(){
        return this.id + "," + this.name + "," + this.lastName + "," + this.username + "," + this.password + "," + this.moneyBalance + "," + this.role;
    }
}