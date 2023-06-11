package com.user.service;

import com.user.dto.MemberDTO;
import com.user.entity.Member;
import com.user.entity.MemberDetail;
import com.user.repository.MemberDetailRepository;
import com.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Log4j2
public class MemberService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberDetailRepository memberDetailRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 회원가입
     *
     * @param memberDto
     */
    public void signUp(MemberDTO memberDto) {

        // 패스워드 암호화
        String encodedPassword = passwordEncoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPassword);

        // Member 객체 생성 및 필드 설정
        Member member = createMemberFromDto(memberDto);

        // MemberDetail 객체 생성 및 필드 설정
        MemberDetail memberDetail = createMemberDetailFromDto(memberDto);

        // 관계 설정
        member.setMemberDetail(memberDetail);
        memberDetail.setMember(member);

        // Member 와 MemberDetail 을 저장합니다.
        memberRepository.save(member);
    }

    /**
     * 회원 조회
     *
     * @param userNo
     */
    public Member memberSelect(Long userNo) {
        return memberRepository.findById(userNo).get();
    }

    /**
     * 회원 상세조회
     *
     * @param userNo
     */
    public MemberDetail memberDetailSelect(Long userNo) {
        return memberDetailRepository.findByMemberNo(userNo);
    }

    /**
     * 회원가입
     *
     * @param memberDto
     */
    public Member login(MemberDTO memberDto) {
        log.debug("Member Id : " + memberDto.getMemberId());
        // 회원 검색
        Member member = memberRepository.findByMemberId(memberDto.getMemberId());
        log.debug("조회한 member : " + member);
        if (member != null) {
            log.debug("회원이 입력한 패스워드 : " + memberDto.getPassword());
            log.debug("디비에서 가져온 암호화 패스워드 : " + member.getPassword());
            // 패스워드 비교(입력한 값, 비교값)
            if (passwordEncoder.matches(memberDto.getPassword(), member.getPassword())) {
                log.debug("회원이 존재 한다면 True");
                return member;
            } else {
                log.debug("회원이 존재하지 않는다면 False");
                throw new UsernameNotFoundException("Invalid username or password.");
            }
        } else {
            log.debug("회원이 존재하지 않는다면 False");
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    /**
     * 회원 객체
     *
     * @param memberDto
     * @return
     */
    private Member createMemberFromDto(MemberDTO memberDto) {

        Member member = new Member();
        member.setMemberId(memberDto.getMemberId());
        member.setPassword(memberDto.getPassword());
        member.setAdminYn(memberDto.getAdminYn());
        member.setSaveStatus(member.getSaveStatus());

        return member;
    }

    /**
     * 회원상세 객체
     *
     * @param memberDetailDto
     * @return
     */
    public MemberDetail createMemberDetailFromDto(MemberDTO memberDetailDto) {

        MemberDetail memberDetail = new MemberDetail();

        memberDetail.setMemberName(memberDetailDto.getMemberName());
        memberDetail.setSsn(memberDetailDto.getSsn());
        memberDetail.setSsn1(memberDetailDto.getSsn1());
        memberDetail.setSsn2(memberDetailDto.getSsn2());
        memberDetail.setPhone(memberDetailDto.getPhone());
        memberDetail.setBankSeq(memberDetailDto.getBankSeq());
        memberDetail.setBankAccount(memberDetailDto.getBankAccount());
        memberDetail.setGender(memberDetailDto.getGender());
        memberDetail.setAddress(memberDetailDto.getAddress());
        memberDetail.setAddress1(memberDetailDto.getAddress1());
        memberDetail.setAddress2(memberDetailDto.getAddress2());
        memberDetail.setZipCode(memberDetailDto.getZipCode());
        memberDetail.setEmail(memberDetailDto.getEmail());
        memberDetail.setTransLevel("B");
        memberDetail.setTransPoint(0);
        memberDetail.setPrivacyPolicy(memberDetailDto.getPrivacyPolicy());
        memberDetail.setAllowPromotions(memberDetailDto.getAllowPromotions());
        memberDetail.setTermsOfService(memberDetailDto.getTermsOfService());

        return memberDetail;
    }

    /**
     * 회원 객체
     *
     * @param member
     * @param memberDetail
     * @return
     */
    public MemberDTO memberDto(Member member, MemberDetail memberDetail) {
        log.debug("memberDto.Member 데이터 : " + member);
        log.debug("memberDto.MemberDetail 데이터 : " + memberDetail);

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setNo(member.getNo());
        memberDTO.setMemberId(member.getMemberId());
        memberDTO.setPassword(member.getPassword());
        memberDTO.setAdminYn(member.getAdminYn());
        memberDTO.setSaveStatus(member.getSaveStatus());


        memberDTO.setMemberName(memberDetail.getMemberName());
        memberDTO.setSsn(memberDetail.getSsn());
        memberDTO.setSsn1(memberDetail.getSsn1());
        memberDTO.setSsn2(memberDetail.getSsn2());
        memberDTO.setPhone(memberDetail.getPhone());
        memberDTO.setBankSeq(memberDetail.getBankSeq());
        memberDTO.setBankAccount(memberDetail.getBankAccount());
        memberDTO.setGender(memberDetail.getGender());
        memberDTO.setAddress(memberDetail.getAddress());
        memberDTO.setAddress1(memberDetail.getAddress1());
        memberDTO.setAddress2(memberDetail.getAddress2());
        memberDTO.setZipCode(memberDetail.getZipCode());
        memberDTO.setEmail(memberDetail.getEmail());
        memberDTO.setTransLevel(memberDetail.getTransLevel());
        memberDTO.setTransPoint(memberDetail.getTransPoint());
        memberDTO.setPrivacyPolicy(memberDetail.getPrivacyPolicy());
        memberDTO.setAllowPromotions(memberDetail.getAllowPromotions());
        memberDTO.setTermsOfService(memberDetail.getTermsOfService());

        return memberDTO;
    }
}
