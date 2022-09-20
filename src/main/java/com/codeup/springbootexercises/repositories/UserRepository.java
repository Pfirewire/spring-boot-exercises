package com.codeup.springbootexercises.repositories;

import com.codeup.springbootexercises.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
