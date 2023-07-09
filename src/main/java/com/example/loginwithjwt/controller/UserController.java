package com.example.loginwithjwt.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@SecurityRequirement(name = "bearerAuth") // basic security : name = "basicAuth"
public class UserController {
    @GetMapping("/home")
    public String home(){
        return "hello from home page";
    }
    @GetMapping("/user")
    public String userPage(){
        return "User Page";
    }
    @GetMapping("/admin")
    public String adminPage(){
        return "Admin page";
    }
    @GetMapping("/admin_user")
    public String adminUserPage(){
        return "Admin and User Page";
    }
}
