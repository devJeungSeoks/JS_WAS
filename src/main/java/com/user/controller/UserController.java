package com.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.user.entity.UserParam;
import com.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private Logger log = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    UserService userService;

    /**
     * 회원가입
     * @param userParam
     */
    @PostMapping("/signUp")
    public void signUp(@RequestBody UserParam userParam) {
        userService.save(userParam);
    }
}
