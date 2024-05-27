package handlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.app.model.Borrower;
import com.example.app.model.Lender;
import com.example.app.model.ROLES;
import com.example.app.model.User;

public class UserCSVHandler implements UserHandler{    
    public static void saveUsers(List<User> users, String path) {
        try (FileWriter writer = new FileWriter(path,false)) {
            for (User user : users) {
                writer.write(user.toCSV() + "\n");
            }
            System.out.println("Users have been saved to CSV file: " + path);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    public static void saveUser(User user, String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(user.toCSV() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    public static List<User> getUsers(String path) {
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
                    float moneyBalance = Float.parseFloat(fields[5]);
                    ROLES role = ROLES.valueOf(fields[6]);
                    if (id.startsWith("B")) {
                        User user = new Borrower(name, lastName, username, password, id, moneyBalance);
                        ((Borrower) user).setId(id);
                        ((Borrower) user).role = role;
                        ((Borrower) user).rentedVehicleID = fields[7];
                        users.add(user);
                    } else if (id.startsWith("L")) {
                        User user = new Lender(name, lastName, username, password, id, moneyBalance);
                        ((Lender) user).setId(id);
                        ((Lender) user).role = role;
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
