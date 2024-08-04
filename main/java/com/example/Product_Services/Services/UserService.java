package com.example.Product_Services.Services;

import com.example.Product_Services.Models.User;

public interface UserService {
    public User signup(String name,String email, String password) throws Exception;
}
