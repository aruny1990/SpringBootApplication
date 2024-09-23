package com.RegistrationApp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RegistrationApp.demo.nodel.User;

public interface UserRepository extends JpaRepository<User,Long> {

    // You can define custom query methods here if needed
    User findByEmail(String email);
}
