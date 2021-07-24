package com.web.blog.test;

import com.web.blog.model.RoleType;
import com.web.blog.model.User;
import com.web.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    @Autowired // 의존성 주입
    private UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(User user){

        System.out.println(user.getUsername());
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }

}
