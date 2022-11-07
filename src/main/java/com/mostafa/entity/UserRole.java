package com.mostafa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.entity.UserRole.java: SpringBootSecurity-JWT
 * @CreationDate 10/2/2022 12:27 PM
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "user_role")
public class UserRole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    private String name;
    private String description;

    @Override
    public String getAuthority() {
        return name;
    }
}
