package com.example.loginwithjwt.service.serivceImp;

import com.example.loginwithjwt.model.UserInfo;
import com.example.loginwithjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findByEmail(username);
        System.out.println("---------- User Info ---------: " + userInfo);
        if(userInfo == null){
            throw new UsernameNotFoundException("NOT FOUND");
        }
        return userInfo;
    }
//
//    public UserInfo addNewUser(UserRequest userRequest){
//        boolean isRole = false;
//        UserInfo userInfo = modelMapper.map(userRequest, UserInfo.class);
//        userInfo.setPassword(passwordEncoder.encode(userRequest.getPassword()));
//        for (Role role: Role.values()){
//            if (userRequest.getRole().equalsIgnoreCase(role.name())){
//                isRole = true;
//                break;
//            }
//        }
//        if(!isRole){
//            throw new RuntimeException();  // custom ROLE NOT FOUND
//        }
//        return userRepository.addNewUser(userInfo);
//    }
}
