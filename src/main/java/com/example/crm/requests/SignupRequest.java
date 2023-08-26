package com.example.crm.requests;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phone;
}
