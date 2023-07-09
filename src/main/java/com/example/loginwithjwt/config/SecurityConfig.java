package com.example.loginwithjwt.config;

import com.example.loginwithjwt.service.serivceImp.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserServiceImpl userServiceImpl;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Bean    // create data access authentication provider
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userServiceImpl);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }


    //    Cannot invoke "org.springframework.security.authentication.AuthenticationManager.authenticate(org.springframework.security.core.Authentication)"
    //    because "this.authenticationManager" is null
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.cors().and().csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(
                        (req) -> req.requestMatchers("/api/v1/users/user").hasRole("USER")
                                .requestMatchers("/api/v1/users/admin").hasRole("ADMIN") // permission
                                .requestMatchers("/api/v1/users/admin_user").hasAnyRole("ADMIN","USER")
                                .requestMatchers("/api/v1/user/home").permitAll()
                                .requestMatchers("/", "/swagger-ui/**","/v3/api-docs/**",
                                        "/swagger-ui-html", "/api/v1/auth/**").permitAll()
                                .anyRequest()
                                .authenticated()

                ).authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
