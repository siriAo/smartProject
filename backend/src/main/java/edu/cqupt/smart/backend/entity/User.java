package edu.cqupt.smart.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package_Name: edu.cqupt.smart.backend.entity
 * @Description: TODO
 * @Date: 2024/2/19 20:29
 * @Created: SiriAo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String nickName;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String nickName, String username, String password) {
        this.nickName = nickName;
        this.username = username;
        this.password = password;
    }
}
