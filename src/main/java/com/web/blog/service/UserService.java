package com.web.blog.service;

import com.web.blog.model.User;
import com.web.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void save(User user){
        userRepository.save(user);
    }

//    @Transactional(readOnly = true) // select 할 때 시작, 서비스 종료시에 트랜잭션 종료(정합성)
//    public User login(User user) {
//        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//    }
}
