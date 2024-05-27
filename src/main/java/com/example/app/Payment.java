package com.example.app;

import com.example.app.model.User;

public class Payment {
    public static boolean processPayment(User from, User to, float amount) {
        if (from.getBalance()<amount){
            return false;
        }
        from.setBalance(from.getBalance()-amount);
        to.setBalance(to.getBalance()+amount);
        return true;
    }
}