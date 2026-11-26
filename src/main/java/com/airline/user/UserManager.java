package com.airline.user;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> users = new ArrayList<User>();

    public void registerUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (findUser(user.getUserId()) != null) {
            throw new IllegalArgumentException("User with ID " + user.getUserId() + " already exists.");
        }
        for (User u : users) {
            if (u.getemail() != null && u.getemail().equals(user.getemail())) {
                throw new IllegalArgumentException("User with email " + user.getemail() + " already exists.");
            }
        }

        users.add(user);
        System.out.println("User registered successfully: " + user.getProfile());
    }

    public User authenticate(String email, String password) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Invalid Email.");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Invalid Password.");
        }

        for (User user : users) {
            if (user != null
                    && user.getPassword() != null
                    && user.getemail() != null
                    && user.getPassword().equals(password)
                    && user.getemail().equals(email)) {
                user.login();
                return user;
            }
        }
        System.out.println("Authentication failed. Invalid email or password.");
        return null;
    }

    public User findUser(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("User ID must be positive.");
        }

        for (User user : users) {
            if (user != null && user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public boolean removeUser(int userId) {
        User userToRemove = findUser(userId);

        if (userToRemove != null) {
            users.remove(userToRemove);
            return true;
        }
        return false;
    }

    public void displayUsers() {
        System.out.println("\n--- System Users ---");
        if (users.isEmpty()) {
            System.out.println("No users registered in the system.");
            return;
        }

        for (User user : users) {
            if (user == null) {
                continue;
            }
            if (user instanceof Passenger) {
                ((Passenger) user).displayInfo();
            } else {
                System.out.println("Admin - " + user.getProfile());
            }
        }
    }
}