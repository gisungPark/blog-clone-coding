package com.web.blog.test;

import com.web.blog.model.RoleType;
import com.web.blog.model.User;
import com.web.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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


    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable Long id){
        Optional<User> findUser = userRepository.findById(id);
        return findUser
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 유저는 없습니다."));
    }


    @GetMapping("/dummy/user/list")
    public List<User> list(){
        return userRepository.findAll();
    }

    // 한페이지당 2건에 데이터를 리턴받아 볼 예정
    @GetMapping("/dummy/user/page")
    public Page<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){

        Page<User> users = userRepository.findAll(pageable);
        return users;
    }

}
