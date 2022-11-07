package com.mostafa;

import com.mostafa.entity.CustomUser;
import com.mostafa.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    @Autowired
    CustomUserRepository userRepository;

    @PostConstruct
    void initUser(){
        List<CustomUser> userList = Stream.of(
                new CustomUser(0, "mostafa", "mostafa", "Golam Mostafa", "mostafa.sna@gmail.com"),
                new CustomUser(0, "admin", "admin", "Admin", "")
        ).collect(Collectors.toList());
        userRepository.saveAll(userList);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

}
