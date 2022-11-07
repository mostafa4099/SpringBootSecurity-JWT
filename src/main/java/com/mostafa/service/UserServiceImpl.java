package com.mostafa.service;

import com.mostafa.entity.CustomUser;
import com.mostafa.entity.UserRole;
import com.mostafa.model.UserModel;
import com.mostafa.repository.CustomUserRepository;
import com.mostafa.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.service.BookServiceImpl.java: SpringBootSecurity-JWT
 * @CreationDate 10/2/2022 12:39 PM
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private CustomUserRepository userRepository;

    @Autowired
    private UserRoleRepository roleRepository;

    @Override
    public Authentication signin(UserModel model) {
        return null;
    }

    @Override
    public CustomUser signup(UserModel model) {
        if (userRepository.findUserByUserName(model.getUserName()).isPresent()) {
            throw new RuntimeException("User Already Exist.");
        } else {
            Optional<UserRole> role = roleRepository.findByName("ROLE_USER");

            CustomUser user = new CustomUser();
            user = user.SetUser(model);
            user.setRoles(Stream.of(role.get()).collect(Collectors.toList()));

            return userRepository.save(user);
        }
    }

    @Override
    public List<CustomUser> getAll() {
        return userRepository.findAll();
    }
}
