package com.example.app;

public interface User {
    String getId();
    String getName();
    String getUsername();
    String getPassword();
    String getLastName();
    String toCSV();
    Enum<ROLES> role = ROLES.USER;
    void addComment(String comment);
}