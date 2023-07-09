package com.example.loginwithjwt.controller;

import com.example.loginwithjwt.model.AuthenticationRequest;
import com.example.loginwithjwt.model.AuthenticationResponse;
import com.example.loginwithjwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authentication ( @RequestBody AuthenticationRequest authenticationRequest){
        System.out.println(" --------- ---------" + authenticationService.authResponse(authenticationRequest));
        return ResponseEntity.ok(authenticationService.authResponse(authenticationRequest));
    }
}
