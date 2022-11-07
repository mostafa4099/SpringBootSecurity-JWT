package com.mostafa.service;

import com.mostafa.entity.CustomUser;
import com.mostafa.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.service.CustomUserDetailService.java: SpringBootSecurity-JWT
 * @CreationDate 11/7/2022 2:59 PM
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    CustomUserRepository userRepository;

    /**
     * Authenticate user using user provided credential.
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CustomUser user = userRepository.findUserByUserName(userName).orElseThrow(
                () -> new UsernameNotFoundException("User name "+userName+" not found.")
        );

        return withUsername(user.getUserName())
                .password(user.getPassword())
                .authorities(user.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
