package com.user.controller;

import com.user.dto.MemberDTO;
import com.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.api.ApiResponse;

@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signUp")
    public ApiResponse signUp(@RequestBody MemberDTO memberDTO) {
        memberService.signUp(memberDTO);
        return new ApiResponse(true,"회원가입이 완료되었습니다.");
    }
}
