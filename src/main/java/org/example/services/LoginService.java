package org.example.services;

import org.example.model.User;
import org.example.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import static org.example.utilities.Colors.*;

import java.util.Scanner;

import static org.example.utilities.Colors.ANSI_BLUE;
import static org.example.utilities.Colors.ANSI_RESET;

public class LoginService {
    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ANSI_BLUE + "Enter username: " + ANSI_RESET);
        String username = scanner.nextLine();

        System.out.print(ANSI_BLUE + "Enter password: " + ANSI_RESET);
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
