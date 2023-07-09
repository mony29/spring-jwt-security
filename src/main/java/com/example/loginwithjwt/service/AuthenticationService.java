package com.example.loginwithjwt.service;

import com.example.loginwithjwt.config.JwtAuthenticationFilter;
import com.example.loginwithjwt.config.JwtUtil;
import com.example.loginwithjwt.model.AuthenticationRequest;
import com.example.loginwithjwt.model.AuthenticationResponse;
import com.example.loginwithjwt.repository.UserRepository;
import com.example.loginwithjwt.service.serivceImp.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserServiceImpl userServiceImpl;
    private final JwtUtil jwtUtil;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    public AuthenticationResponse authResponse(AuthenticationRequest authRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );

        var user = userRepository.findByEmail(authRequest.getEmail());
        System.out.println("--------- User information : " + user + " ----------");
        var jwtToken = jwtUtil.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
