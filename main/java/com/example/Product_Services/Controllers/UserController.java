package com.example.Product_Services.Controllers;

import com.example.Product_Services.DTOS.LogInReqDTO;
import com.example.Product_Services.DTOS.SignUpReqDTO;
import com.example.Product_Services.DTOS.ValidateTokenReqDTO;
import com.example.Product_Services.Models.Token;
import com.example.Product_Services.Models.User;
import com.example.Product_Services.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpReqDTO reqDTO){
        try{
//            reqDTO.setName("Pandya");
//            reqDTO.setPassword("pratik1234");
//            reqDTO.setEmail("pratik@gmail.com");
            //TODO basic validation on getting Empty reqDTO
            System.out.println(reqDTO + "DTOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
            User user = userService.signup(reqDTO.getName(), reqDTO.getEmail(), reqDTO.getPassword());
            return new ResponseEntity<>(user, HttpStatusCode.valueOf(201));
        }catch (Exception e){
            System.out.println("Wrooooorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));

        }
    }

    @PostMapping("/login")
    public ResponseEntity<Token> logIn(@RequestBody LogInReqDTO reqDTO){
        return null;
    }
    @PostMapping("/validate_token")
    public ResponseEntity<Token> validateToken(@RequestBody ValidateTokenReqDTO reqDTO){
        return null;
    }
}
