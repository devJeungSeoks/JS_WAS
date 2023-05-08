package com.login.controller;

import com.login.model.Login;
import com.login.service.LoginService;
import com.user.entity.UserMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import util.jwt.JwtAuthenticationResponse;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Login login) {
        UserMember userMember = loginService.getUser(login.getId(), login.getPassword());
        if (userMember == null) {
            return ResponseEntity.ok(null);
        } else {
            String token = loginService.authenticateUser(userMember.getUserId(), userMember.getPassword());
            return ResponseEntity.ok(new JwtAuthenticationResponse(token));
        }
    }

}
