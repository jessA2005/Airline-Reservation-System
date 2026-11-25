import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> users;

    public void registerUser(User user) {

        users.add(user);
        System.out.println("User registered successfully: " + user.getProfile());
    }

    public User authenticate(String email, String paaword){

        for(User user:users){
            
            if(user.getPassword().equals(paaword) && user.getemail().equals(email)){
                user.login();
                return user;
            }
        }
        System.out.println("Authentication failed. Invalid email or password.");
        return null;
    }

    public User findUser(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
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

            if (user instanceof Passenger) {
               ((Passenger) user).displayInfo();
            } else {
                System.out.println("Admin - " + user.getProfile());
            }
        }
    }
}