package com.example.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserCSVHandler {
    public void saveUsersToCSV(String path, List<User> users) {
        try (FileWriter writer = new FileWriter(path)) {
            for (User user : users) {
                writer.write(user.toCSV() + "\n");
            }
            System.out.println("Users have been saved to CSV file: " + path);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    public static void saveUserToCSV(String path, User user) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(user.toCSV() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    public static List<User> getUsersFromCSV(String path) {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 7) {
                    String id = fields[0];
                    String name = fields[1];
                    String lastName = fields[2];
                    String username = fields[3];
                    String password = fields[4];
                    if (id.startsWith("B")) {
                        User user = new Borrower(name, lastName, username, password, id);
                        ((Borrower) user).setId(id);
                        users.add(user);
                    } else if (id.startsWith("L")) {
                        User user = new Lender(name, lastName, username, password, id);
                        ((Lender) user).setId(id);
                        users.add(user);
                    }
                }
            }
            System.out.println("Users have been loaded from CSV file: " + path);
        } catch (IOException e) {
            System.err.println("Error reading from CSV file: " + e.getMessage());
        }
        return users;
    }
}
