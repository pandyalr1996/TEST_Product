package com.example.Product_Services.DTOS;

import lombok.Data;
@Data
public class SignUpReqDTO {
    private String name;
    private String password;
    private String email;
}
