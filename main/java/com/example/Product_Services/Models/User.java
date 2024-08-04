package com.example.Product_Services.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String password;
    private String email;
    @ElementCollection
    private List<Role> roles;
}
