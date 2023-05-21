package com.user;

import com.user.controller.MemberController;
import com.user.dto.MemberDTO;
import com.user.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
public class MemberTests {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberController memberController;



    @Test
    public void selectTest() {
        List goods = memberRepository.findAll();

        System.out.println("list : " + goods);
    }
    @Test
    public void createTest(){

        MemberDTO goodsDTO = new MemberDTO();
        goodsDTO.setMemberId("mias23s");
        goodsDTO.setPassword("23");
        goodsDTO.setAdminYn("N");
        goodsDTO.setSaveStatus("Y");


        goodsDTO.setMemberId("Test");
        goodsDTO.setMemberName("TestName");
        goodsDTO.setGender("M");
        goodsDTO.setSsn("9601281234567");
        goodsDTO.setSsn1("960228");
        goodsDTO.setSsn2("1234567");
        goodsDTO.setEmail("dsaj@naver.com");
        goodsDTO.setPhone("01034340069");
        goodsDTO.setAddress("경기도 수원시 팔달구");
        goodsDTO.setAddress1("메산로 14");
        goodsDTO.setAddress2("동남아파트 101동 101호");
        goodsDTO.setZipCode("12352");
        goodsDTO.setBankAccount("62350101123456");
        goodsDTO.setBankSeq("001");
        goodsDTO.setTransLevel("1");
        goodsDTO.setTransPoint(0);

        memberController.signUp(goodsDTO);

    }

    @Test
    public void passwordEncodeTest(){
        String decodePassword = "23";

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 패스워드를 암호화합니다.
        String encodedPassword = passwordEncoder.encode(decodePassword);
        System.out.println(encodedPassword);

    }
}