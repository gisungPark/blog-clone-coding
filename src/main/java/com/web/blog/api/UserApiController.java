package com.web.blog.api;

import com.web.blog.dto.ResponseDto;
import com.web.blog.model.RoleType;
import com.web.blog.model.User;
import com.web.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    UserService userService;

    @GetMapping("/auth/test")
    public String securityTest(){
        return "들어왔다!!";
    }

    @PostMapping("/auth/join")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApicontroller : save 호출됨!");
        user.setRole(RoleType.USER);

        userService.save(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


}
