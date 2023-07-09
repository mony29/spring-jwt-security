//package com.example.loginwithjwt.config;
//
//import com.example.loginwithjwt.service.serivceImp.UserServiceImpl;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@AllArgsConstructor
//public class DatabaseSecurityConfig {
//    private final UserServiceImpl userServiceImpl;
//    private final BCryptPasswordEncoder passwordEncoder;
//    @Bean
//    DaoAuthenticationProvider daoAuthenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userServiceImpl);
//        authenticationProvider.setPasswordEncoder(passwordEncoder);
//        return authenticationProvider;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//
//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests(
//                        (req) -> req.requestMatchers("/api/v1/users/user").hasRole("USER")
//                                .requestMatchers("/api/v1/users/admin").hasRole("ADMIN") // permission
//                                .requestMatchers("/api/v1/users/admin_user").hasAnyRole("ADMIN","USER")
//                                .requestMatchers("/api/v1/user/home").permitAll()
//                                .requestMatchers("/", "/swagger-ui/**","/v3/api-docs/**",
//                                        "/swagger-ui-html", "/api/v1/users/**").permitAll()
//                                .anyRequest()
//                                .authenticated()
//
//                ).formLogin().disable().httpBasic().authenticationEntryPoint((request, response, authException) ->{
//                    response.sendError(HttpStatus.UNAUTHORIZED.value(),
//                            HttpStatus.UNAUTHORIZED.getReasonPhrase());
//                }); // .disable() is to clear form login because swagger has it own login form
//        return httpSecurity.build();
//    }
//}
