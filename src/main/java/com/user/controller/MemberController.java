package com.user.controller;

import com.config.jwt.JwtTokenProvider;
import com.user.entity.Member;
import com.user.entity.MemberCash;
import com.user.entity.MemberDetail;
import com.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@Log4j2
public class MemberController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;


    @PostMapping("/signUp")
    public Long signUp(@RequestBody Map<String, String> member) {
        log.debug("회원가입 들어온 데이터 : " + member);

        Member newMember = Member.builder()
                .memberId(member.get("memberId"))
                .password(passwordEncoder.encode(member.get("password")))
                .adminYn(member.get("adminYn"))
                .saveStatus("Y")
                .roles(Collections.singletonList("ROLE_USER"))  //최초 가입시 USER로 설정
                .build();

        MemberDetail memberDetail = MemberDetail.builder()
                .member(newMember)
                .memberName(member.get("memberName"))
                .ssn(member.get("ssn"))
                .ssn1(member.get("ssn1"))
                .ssn2(member.get("ssn2"))
                .phone(member.get("phone"))
                .bankSeq(member.get("bankSeq"))
                .bankAccount(member.get("bankAccount"))
                .gender(member.get("gender"))
                .address(member.get("address"))
                .address1(member.get("address1"))
                .address2(member.get("address2"))
                .zipCode(member.get("zipCode"))
                .transPoint(0)
                .transLevel("B")
                .email(member.get("email"))
                .privacyPolicy(member.get("privacyPolicy"))
                .allowPromotions(member.get("allowPromotions"))
                .termsOfService(member.get("termsOfService"))
                .build();

        // 관계 설정
        memberDetail.setMember(newMember);
        newMember.setMemberDetail(memberDetail);

        MemberCash memberCash = new MemberCash();
        memberCash.setMember(newMember);
        newMember.setMemberCash(memberCash);

        // Member 와 MemberDetail 을 저장합니다.
        return memberRepository.save(newMember).getNo();
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        log.debug("로그인 들어온 데이터 : " + user);

        Member member = memberRepository.findByMemberId(user.get("memberId"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-Mail 입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }
}
