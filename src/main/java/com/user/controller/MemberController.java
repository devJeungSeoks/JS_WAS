package com.user.controller;

import com.user.dto.MemberDTO;
import com.user.entity.Member;
import com.user.entity.MemberDetail;
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
        return new ApiResponse(true, "회원가입이 완료되었습니다.");
    }

    @PostMapping("/login")
    public MemberDetail login(@RequestBody MemberDTO memberDTO) {
        Member member = memberService.login(memberDTO);

        if (member != null) {
            memberDTO.setNo(member.getNo());
            MemberDetail memberDetail = memberService.memberDetailSelect(memberDTO.getNo());
            return memberDetail;
        } else {
            return null;
        }
    }
}
