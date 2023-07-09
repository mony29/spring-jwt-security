//package com.example.loginwithjwt.config;
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity // close default user & password that auto generate
//@AllArgsConstructor // create constructor
//public class InMemoryUserConfig {
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    // create users with role
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user = User.withUsername("user")
//                .password(bCryptPasswordEncoder.encode("12345"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password(bCryptPasswordEncoder.encode("12345"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//
//    // specific where the user can access (route)
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//
//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests(
//                        (req) -> req.requestMatchers("/api/v1/users/user").hasRole("USER")
//                                .requestMatchers("/api/v1/users/admin").hasRole("ADMIN") // permission
//                                .requestMatchers("/api/v1/users/admin_user").hasAnyRole("ADMIN","USER")
//                                .requestMatchers("/api/v1/user/home").permitAll()
//                                .anyRequest()
//                                .authenticated()
//
//                ).formLogin().disable().httpBasic().authenticationEntryPoint((request, response, authException) ->{
//                    response.sendError(HttpStatus.UNAUTHORIZED.value(),
//                            HttpStatus.UNAUTHORIZED.getReasonPhrase());
//                        }); // .disable() is to clear form login because swagger has it own login form
//        return httpSecurity.build();
//    }
//}
