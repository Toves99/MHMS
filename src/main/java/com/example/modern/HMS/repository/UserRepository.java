package com.example.modern.HMS.repository;

import com.example.modern.HMS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    // User findByEmail(String email);
    Optional<User> findByEmail(String email);
}
