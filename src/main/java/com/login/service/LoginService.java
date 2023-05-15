package com.login.service;

import com.login.repository.LoginRepository;
import com.user.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import util.jwt.JwtTokenProvider;


@Service
public class LoginService {

    @Autowired
    public LoginRepository repository;


    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    Logger log = LoggerFactory.getLogger(getClass().getName());

//    public String authenticateUser(String userId, String password) {
//        // username, password 검증 로직
//        if (isValidUser(userId, password)) {
//            return JwtTokenProvider.generateToken(userId);
//        } else {
//            throw new UnauthorizedException("Invalid username or password");
//        }
//    }

    public Member getUser(String userId, String password) {
        String encPwd = passwordEncoder.encode(password);

        if(passwordEncoder.matches(password, encPwd) == true) {
            return repository.findByMemberId(userId);
        } else {
            return new Member();
        }
    }

    private boolean isValidUser(String userId, String password) {
        // 사용자 인증 로직
        if (repository.findByMemberIdAndPassword(userId, password) == null) {
            return false;
        } else {
            return true;
        }
    }

}
