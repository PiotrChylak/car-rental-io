package com.example.app.model;

public interface User {
    String getId();
    String getName();
    String getUsername();
    String getPassword();
    String getLastName();
    String toCSV();
    float getBalance();
    void setBalance(float amount);
    Enum<ROLES> role = ROLES.USER;
    void addComment(String comment);
}