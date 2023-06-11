package com.user.controller;

import com.user.dto.MemberDTO;
import com.user.entity.Member;
import com.user.entity.MemberDetail;
import com.user.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.api.ApiResponse;

@RestController
@RequestMapping("/user")
@Log4j2
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signUp")
    public ApiResponse signUp(@RequestBody MemberDTO memberDTO) {
        log.debug("회원가입 들어온 데이터 : " + memberDTO);
        memberService.signUp(memberDTO);
        return new ApiResponse(true, "회원가입이 완료되었습니다.");
    }

    @PostMapping("/login")
    public MemberDTO login(@RequestBody MemberDTO memberDTO) {
        log.debug("로그인 들어온 데이터 : " + memberDTO);
        try {
            Member member = memberService.login(memberDTO);
            log.debug("Member Entity Data : " + member);

            if (member.getNo() != null) {
                MemberDetail memberDetail = memberService.memberDetailSelect(member.getNo());
                log.debug("Member Data : " + memberService.memberDto(member, memberDetail));
                return memberService.memberDto(member, memberDetail);
            } else {
                log.debug("데이터가 존재하지 않음.");
                return null;
            }

        } catch (Exception e) {
            log.debug("데이터가 존재하지 않음.");
            return null;
        }

    }
}
