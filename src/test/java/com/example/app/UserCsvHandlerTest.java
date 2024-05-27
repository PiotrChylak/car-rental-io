package com.example.app;

import org.junit.jupiter.api.Test;

import com.example.app.model.Borrower;
import com.example.app.model.Lender;
import com.example.app.model.ROLES;
import com.example.app.model.User;

import handlers.UserCSVHandler;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

class UserCSVHandlerTest {

    @Test
    void testSaveUsersToCSV() throws IOException {
        List<User> users = new ArrayList<>();
        Borrower borrower = new Borrower("John", "Doe", "johndoe", "password", null,50);
        borrower.rentedVehicleID = "C1";
        users.add(borrower);
        Lender lender = new Lender("Jane", "Smith", "janesmith", "password", null,0);
        users.add(lender);
        
        String path = "users.csv";
        UserCSVHandler.saveUsers(users, path);
        UserCSVHandler.getUsers(path).forEach(user -> {
            if (user instanceof Borrower) {
                Borrower b = (Borrower) user;
                assert b.getName().equals("John");
                assert b.getLastName().equals("Doe");
                assert b.getUsername().equals("johndoe");
                assert b.getPassword().equals("password");
                assert b.rentedVehicleID.equals("C1");
                assert b.getBalance() == 50;

            } else if (user instanceof Lender) {
                Lender l = (Lender) user;
                assert l.getName().equals("Jane");
                assert l.getLastName().equals("Smith");
                assert l.getUsername().equals("janesmith");
                assert l.getPassword().equals("password");
                assert l.getBalance() == 0;
                assert l.role == ROLES.USER;
            }
        });
        System.err.println("testSaveUsersToCSV passed");
    }

}
