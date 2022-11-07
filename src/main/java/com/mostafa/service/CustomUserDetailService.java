package com.mostafa.service;

import com.mostafa.entity.CustomUser;
import com.mostafa.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.service.CustomUserDetailService.java: SpringBootSecurity-JWT
 * @CreationDate 11/7/2022 2:59 PM
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    CustomUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CustomUser customUser = userRepository.findUserByUserName(userName);
        return new User(customUser.getUserName(), customUser.getPassword(), new ArrayList<>());
    }
}
