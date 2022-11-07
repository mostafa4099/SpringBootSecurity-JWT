package com.mostafa.repository;

import com.mostafa.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.repository.CustomUserRepository.java: SpringBootSecurity-JWT
 * @CreationDate 10/2/2022 12:35 PM
 */

public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
    CustomUser findUserByUserName(String username);
}
