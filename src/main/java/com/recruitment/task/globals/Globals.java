package com.recruitment.task.globals;

import com.recruitment.task.models.User;

import java.util.ArrayList;

public class Globals {
    public static final String TRANSACTIONS_KEY = "transaction";
    public static final String FEE_WAGES_KEY = "fee_wages";
    //  for authentication test purposes, in development list users will be in DB
    public static ArrayList<User> users = new ArrayList<>();
    public static void loadUsers() {
        users.add(new User("digital", "collier", "ADMIN"));
        users.add(new User("user1", "user1pwd", "USER"));
        users.add(new User("user2", "user2pwd", "USER"));
    }
}