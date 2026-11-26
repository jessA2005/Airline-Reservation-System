package com.airline.user;

public abstract class User {

    protected int userId;
    protected String name;
    protected String email;
    protected String password;
    protected boolean isLoggedIn;

    public User(int userId, String name, String email, String password) {
        if (userId <= 0) {
            throw new IllegalArgumentException("User ID must be positive.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (email == null || email.isEmpty() || !email.contains("@") || email.contains(" ")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }

        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isLoggedIn = false;
    }

    public boolean login() {
        if (isLoggedIn) {
            System.out.println(name + " is already logged in.");
            return true;
        }

        isLoggedIn = true;
        System.out.println(name + " has successfully Logged in.");

        return true;
    }

    public void logout() {
        if (!isLoggedIn) {
            throw new IllegalStateException(name + " is not logged in.");
        }

        isLoggedIn = false;
        System.out.println(name + " has successfully Logged out.");
    }

    public String getProfile() {

        return "-ID: " + userId + "\n-Name: " + name + "\n-Email: " + email;

    }

    public int getUserId() {
        return userId;
    }

    public String getemail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
