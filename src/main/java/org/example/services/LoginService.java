package org.example.services;

import org.example.model.User;
import org.example.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Scanner;

public class LoginService {
    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = userRepository.getUserByUsername(username);

        if (user != null && verifyPassword(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    private boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
