public abstract class User {

    protected int userId;
    protected String name;
    protected String email;
    protected String password;
    protected boolean isLoggedIn;

    public User(int userId, String name, String email, String password) {

        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isLoggedIn = false;

    }

    public boolean login() {

        isLoggedIn = true;
        System.out.println(name + " has successfully Logged in.");

        return true;
    }

    public void logout() {

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
