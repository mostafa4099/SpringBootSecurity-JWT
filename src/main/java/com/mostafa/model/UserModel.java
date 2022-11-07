package com.mostafa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.entity.CustomUser.java: SpringBootSecurity-JWT
 * @CreationDate 10/2/2022 12:27 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserModel {
    private String userName;
    private String password;
    private String name;
    private String email;
}
