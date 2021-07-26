package com.web.blog.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class SecurityConfigTest {

    @Test
    public void 해쉬_암호화() throws Exception{
        //given
        String encPassword = new BCryptPasswordEncoder().encode("1234");
        System.out.println(encPassword);
        //when

        //then
     }

}