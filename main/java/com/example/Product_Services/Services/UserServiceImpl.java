package com.example.Product_Services.Services;

import com.example.Product_Services.Models.User;
import com.example.Product_Services.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepo userRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }



    @Override
    public User signup(String name, String email, String password) throws Exception {
        Optional<User> optionalUser = userRepo.findUserByEmail(email);
        if(optionalUser.isEmpty()){
            throw  new Exception("User is already exist");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoderPassword= encoder.encode(password);
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encoderPassword);

        return this.userRepo.save(user);
    }
}
