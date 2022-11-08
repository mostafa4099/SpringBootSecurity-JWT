package com.mostafa;

import com.mostafa.entity.CustomUser;
import com.mostafa.entity.UserRole;
import com.mostafa.repository.CustomUserRepository;
import com.mostafa.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CustomUserRepository userRepository;

    /**
     * Create user and user roles
     */
    @PostConstruct
    void initUser(){
        UserRole adminRole = new UserRole(0, "ROLE_ADMIN", "Admin");
        UserRole savedAdminRole = userRoleRepository.save(adminRole);

        UserRole userRole = new UserRole(0, "ROLE_USER", "User");
        UserRole savedUserRole = userRoleRepository.save(userRole);

        List<UserRole> adminRoles = Stream.of(savedAdminRole,savedUserRole).collect(Collectors.toList());
        List<UserRole> userRoles = Stream.of(savedUserRole).collect(Collectors.toList());

        List<CustomUser> userList = Stream.of(
                new CustomUser(0, "mostafa", passwordEncoder.encode("mostafa"), "Golam Mostafa", "mostafa.sna@gmail.com", userRoles),
                new CustomUser(0, "admin", passwordEncoder.encode("admin"), "Admin", "", adminRoles)
        ).collect(Collectors.toList());

        userRepository.saveAll(userList);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

}
