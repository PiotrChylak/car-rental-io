package com.example.app;
import org.apache.commons.codec.digest.DigestUtils;
public class Authentication {
    public boolean checkID(String id) {
        return id != null && !id.isEmpty();
    }

    public void login(String username, String password) {
        if (checkID(username) && checkID(password)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }

    public static String hashPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }
}