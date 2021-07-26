package com.web.blog.repository;

import com.web.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    
    //JPA Naming 전략
    // SELECT * FROM user WHERE username = ? AND password = ?
    // User findByUsernameAndPassword(String username, String password);

    // @Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
    // User login(String username, String password);

}
