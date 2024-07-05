// package com.chamod.taskmanager.repo;

// import org.springframework.data.jpa.repository.JpaRepository;

// import com.chamod.taskmanager.entity.User;



// public interface UserRepo extends JpaRepository<User, Long> {
//     User findByUsername(String username);
// }
package com.chamod.taskmanager.repo;

import com.chamod.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}