// package com.chamod.taskmanager.entity;

// import jakarta.persistence.*;
// import lombok.*;

// @AllArgsConstructor
// @NoArgsConstructor
// @Getter
// @Setter
// @ToString

// @Entity
// @Table(name = "user")
// public class User{
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String username;
//     private String password;
//     private String role;

//     public User(String username, String password,String role ) {

//         this.username = username;
//         this.password = password;
//         this.role = role;
//     }
// }
package com.chamod.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "users") // Updated table name to avoid conflicts
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;
}
