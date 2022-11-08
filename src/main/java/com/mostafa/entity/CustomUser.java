package com.mostafa.entity;

import com.mostafa.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.List;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.entity.CustomUser.java: SpringBootSecurity-JWT
 * @CreationDate 10/2/2022 12:27 PM
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "custom_user")
public class CustomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    private String userName;
    private String password;
    private String name;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<UserRole> roles;

    public CustomUser SetUser(UserModel model, PasswordEncoder encoder) {
        this.userName = model.getUserName();
        this.password = encoder.encode(model.getPassword());
        this.name = model.getName();
        this.email = model.getEmail();
        return this;
    }
}
