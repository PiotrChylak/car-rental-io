package com.example.app;

import java.util.Scanner;

public class TextHandler {
    private Scanner scanner;
    private RentalSystem system;
    private Authentication auth;
    private User loggedUser;

    public TextHandler(Scanner scanner, RentalSystem system, Authentication auth) {
        this.scanner = scanner;
        this.system = system;
        this.auth = auth;
        this.loggedUser = null;
    }

    public void displayMainMenu() {
        System.out.println("Login or if you don't have an account register and login");
        System.out.println("[1] Register");
        System.out.println("[2] Login");
    }

    public void registration(){
        System.out.println("Choose your role:\n[1] Lender\n[2] Borrower");
        int roleOption = scanner.nextInt();
        if(roleOption == 1) {
            System.out.println("Now you are registering as Lender.\n");
        } else if(roleOption == 2) {
            System.out.println("Now you are registering as Borrower.\n");
        }

        System.out.println("Enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter last name:");
        String lastName = scanner.next();

        User newUser;
        if (roleOption == 1) {
            newUser = new Lender(name, lastName, username, Authentication.hashPassword(password), null);
            system.registerUser(newUser);
        }
        else if (roleOption == 2) {
            newUser = new Borrower(name, lastName, username, Authentication.hashPassword(password),null);
            system.registerUser(newUser);
        }
    }

    public void LenderMenu(){};

    public void BorrowerMenu(){};

    public User login(){
        System.out.println("Enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        loggedUser = auth.login(username, password, system.users);
        if (loggedUser != null) {
            return loggedUser;
        }
            return null;
    }
}
