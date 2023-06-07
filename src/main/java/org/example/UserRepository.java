package org.example;

import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> users;

    public UserRepository() {
        users = new HashMap<>();
        // Populate with some initial users
        users.put("staff1", new User("staff1", hashPassword("staff1password"), Role.STAFF));
        users.put("manager1", new User("manager1", hashPassword("manager1password"), Role.MANAGER));
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }

    // Password hashing function
    private String hashPassword(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }
}

