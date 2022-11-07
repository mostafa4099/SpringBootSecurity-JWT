package com.mostafa.controller;

import com.mostafa.entity.CustomUser;
import com.mostafa.model.UserModel;
import com.mostafa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.controller.BookController.java: SpringBootSecurity-JWT
 * @CreationDate 10/2/2022 12:49 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public Authentication login(@RequestBody UserModel model) {
        return userService.signin(model) ;
    }

    @PostMapping("/signup")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CustomUser signup(@RequestBody UserModel model){
        return userService.signup(model);
    }
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<CustomUser> getAllUsers() {
        return userService.getAll();
    }
}
