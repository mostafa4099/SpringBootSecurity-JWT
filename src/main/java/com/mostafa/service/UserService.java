package com.mostafa.service;

import com.mostafa.entity.CustomUser;
import com.mostafa.excption.NotFoundException;
import com.mostafa.model.UserModel;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.service.BookService.java: SpringBootSecurity-JWT
 * @CreationDate 10/2/2022 12:36 PM
 */
public interface UserService {
    Optional<String> signin(UserModel model) throws NotFoundException;

    CustomUser signup(UserModel model);

    List<CustomUser> getAll();
}
