package com.web.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin("*")
@Controller
public class UserController {

    @GetMapping("/auth/loginForm")
    public String loginForm(HttpServletResponse response){
        response.setHeader("Content-Type", "application/javascript");


        return "user/loginForm";
    }

    @GetMapping("/auth/joinForm")
    public String joinForm(){
        return "user/joinForm";
    }

}
