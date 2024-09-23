package com.RegistrationApp.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.RegistrationApp.demo.nodel.User;
import com.RegistrationApp.demo.repository.UserRepository;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) throws Exception {
        // Validate email
        if (!isValidEmail(user.getEmail())) {
            throw new Exception("Invalid email format");
        }

        // Hash the password
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        // Create new User entity
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(hashedPassword);
        newUser.setName(user.getName());

        // Save to DB
        userRepository.save(newUser);
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
    
    public String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    
    public boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }

}
