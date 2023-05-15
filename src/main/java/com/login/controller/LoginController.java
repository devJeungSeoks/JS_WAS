//package com.login.controller;
//
//import com.login.model.Login;
//import com.login.service.LoginService;
//import com.user.entity.Member;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
////import util.jwt.JwtAuthenticationResponse;
//
//@Controller
//public class LoginController {
//    @Autowired
//    private LoginService loginService;
//
//
//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@RequestBody Login login) {
//        Member member = loginService.getUser(login.getId(), login.getPassword());
//        if (member == null) {
//            return ResponseEntity.ok(null);
//        } else {
//            String token = loginService.authenticateUser(member.getMemberId(), member.getPassword());
//            return ResponseEntity.ok(new JwtAuthenticationResponse(token));
//        }
//    }
//
//}
