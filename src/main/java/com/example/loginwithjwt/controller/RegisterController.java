package com.example.loginwithjwt.controller;

import com.example.loginwithjwt.model.UserRequest;
import com.example.loginwithjwt.service.serivceImp.UserServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class RegisterController {
    private final UserServiceImpl userServiceImpl;
    @PostMapping("/register")
    public String register(@RequestBody UserRequest userRequest){
//        if(userServiceImpl.addNewUser(userRequest)!=null){
//            return "Success";
//        }
        return null;
    }

}
