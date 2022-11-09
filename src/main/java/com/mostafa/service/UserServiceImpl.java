package com.mostafa.service;

import com.mostafa.config.JwtProvider;
import com.mostafa.entity.CustomUser;
import com.mostafa.entity.UserRole;
import com.mostafa.excption.NotFoundException;
import com.mostafa.model.UserModel;
import com.mostafa.repository.CustomUserRepository;
import com.mostafa.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    /**
     * Pass user provided credential to loadUserByUsername() method of CustomUserService
     * using AuthenticationManager.
     *
     * @param model
     * @return
     */
    @Override
    public Optional<String> signin(UserModel model) throws NotFoundException {
        Optional<String> token = Optional.empty();
        Optional<CustomUser> user = userRepository.findUserByUserName(model.getUserName());
        if (!user.isPresent()) {
            throw new NotFoundException("User not found!");
        } else {
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(model.getUserName(), model.getPassword()));
                token = Optional.of(jwtProvider.createToken(model.getUserName(), user.get().getRoles()));
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
        }
        return token;
    }

    @Override
    public CustomUser signup(UserModel model) {
        if (userRepository.findUserByUserName(model.getUserName()).isPresent()) {
            throw new RuntimeException("User Already Exist.");
        } else {
            Optional<UserRole> role = roleRepository.findByName("ROLE_USER");

            CustomUser user = new CustomUser();
            user = user.SetUser(model, passwordEncoder);
            user.setRoles(Stream.of(role.get()).collect(Collectors.toList()));

            user = userRepository.save(user);

            user.setPassword("");

            return user;
        }
    }

    @Override
    public List<CustomUser> getAll() {
        List<CustomUser> userList = userRepository.findAll();

        userList = userList.stream().map(user -> {
            user.setPassword("");
            return user;
        }).collect(Collectors.toList());

        return userList;
    }
}
