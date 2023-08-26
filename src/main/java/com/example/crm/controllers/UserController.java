package com.example.crm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/secured")
public class UserController {
    @GetMapping("/user")
    public String getUser(Principal principal) {
        if (principal == null) return null;
        return principal.getName();
    }
}
