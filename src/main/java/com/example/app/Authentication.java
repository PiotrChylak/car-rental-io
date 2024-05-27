package com.example.app;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;

import com.example.app.model.User;
public class Authentication {
    public static String hashPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }
    public static User login(String username, String password, List<User> users) {
        Optional<User> user = users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(Authentication.hashPassword(password)))
                .findFirst();
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
}