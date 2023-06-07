package org.example.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.example.Role;
import org.example.model.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {
    private Map<String, User> users;

    private Scanner scanner;

    public UserService() {
        users = new HashMap<>();
        // Populate with some initial users
        users.put("staff1", new User("staff1", hashPassword("staff1password"), Role.STAFF));
        users.put("manager1", new User("manager1", hashPassword("manager1password"), Role.MANAGER));

        scanner = new Scanner(System.in); // Initialize the scanner
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }

    public void registerUser(Role role) {
        // Logic for user registration

        // Prompt the user to enter their desired username and password
        String username = promptUsername();
        String password = promptPassword();

        // Validate the username (e.g., check for uniqueness)
        boolean isUsernameValid = validateUsername(username);

        if (isUsernameValid) {
            // Create a new user account with the provided username and password
            createUserAccount(username, password, role);

            // Inform the user that the registration was successful
            System.out.println("Registration successful. Please log in with your new account.");
        } else {
            // Username is not valid (e.g., already exists)
            System.out.println("Username is already taken. Please choose a different username.");
        }
    }

    private String promptUsername() {
        System.out.print("Enter your username: ");
        return scanner.nextLine();
    }

    private String promptPassword() {
        System.out.print("Enter your password: ");
        return scanner.nextLine();
    }

    private boolean validateUsername(String username) {
        // Logic to validate the uniqueness of the username
        // Return true if the username is valid, false otherwise
        return !users.containsKey(username);
    }

    private void createUserAccount(String username, String password, Role role) {
        // Logic to create a new user account with the provided username and password
        String hashedPassword = hashPassword(password);
        users.put(username, new User(username, hashedPassword, role));
    }

    public void loginUser() {
        // Logic for user login

        // Prompt the user to enter their username and password
        String username = promptUsername();
        String password = promptPassword();

        // Retrieve the user object based on the entered username
        User user = getUserByUsername(username);

        if (user != null && verifyPassword(password, user.getPassword())) {
            // User is logged in successfully
            System.out.println("Logged in as " + username);
        } else {
            // Invalid username or password
            System.out.println("Invalid username or password");
        }
    }

    private boolean verifyPassword(String password, String hashedPassword) {
        // Verify the entered password against the stored hashed password
        return BCrypt.checkpw(password, hashedPassword);
    }

    // Password hashing function
    private String hashPassword(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }

    private void logoutUser() {
        // Logic for user logout
        // Perform any necessary cleanup or session management
        System.out.println("Logged out");
    }

    private void exitApplication() {
        // Logic to exit the application
        System.out.println("Exiting the application");
        System.exit(0);
    }
}

