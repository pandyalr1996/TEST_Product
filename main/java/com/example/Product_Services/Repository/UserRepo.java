package com.example.Product_Services.Repository;

import com.example.Product_Services.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findUserByEmail(String email);
}
