package com.user;

import com.config.jwt.JwtTokenProvider;
import com.user.controller.MemberController;
import com.user.entity.Member;
import com.user.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class MemberTests {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberController memberController;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Test
    public void passwordEncodeTest() {
        String decodePassword = "23";

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 패스워드를 암호화합니다.
        String encodedPassword = passwordEncoder.encode(decodePassword);
        System.out.println("encodedPassword : " + encodedPassword);

    }


    @Test
    public void login() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pasa = "$2a$10$9cCwdrdwH09zmLCPL8qHh.inZx.4nZsi4DTianCyIM4QcwyRCejBu";
        passwordEncoder.matches("223", pasa);
    }

    @Test
    public void jwtTest() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuZDIyMyIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2ODczNTEyODcsImV4cCI6MTY4NzQzNzY4N30.D3ogg1FVz4uZ3B3G5xxjM87_95W0kGz4yr2lvQnXiaY";
        Authentication authentication = jwtTokenProvider.getAuthentication(token);
        System.out.println("authentication : " + authentication);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) authentication;
        System.out.println("usernamePasswordAuthenticationToken : " + usernamePasswordAuthenticationToken.getPrincipal());

        Member member = (Member) usernamePasswordAuthenticationToken.getPrincipal();
        System.out.println(member.getMemberId());
    }
}
