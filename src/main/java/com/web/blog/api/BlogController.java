package com.web.blog.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/hello")
    public String hello(){

        return "test";
    }

}
