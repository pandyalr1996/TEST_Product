package com.example.Product_Services.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String value;
    @ManyToOne
    private User user;
    private int expiryAt;
}
