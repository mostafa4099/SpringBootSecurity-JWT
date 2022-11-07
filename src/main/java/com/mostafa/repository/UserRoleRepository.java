package com.mostafa.repository;

import com.mostafa.entity.CustomUser;
import com.mostafa.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.repository.UserRoleRepository.java: SpringBootSecurity-JWT
 * @CreationDate 10/2/2022 12:35 PM
 */

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByName(String name);
}
