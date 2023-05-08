package com.user.service;

import com.user.entity.UserCash;
import com.user.entity.UserMember;
import com.user.entity.UserMemberDetail;
import com.user.entity.UserParam;
import com.user.repository.UserCashRepository;
import com.user.repository.UserDetailRepository;
import com.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.function.Util;


@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserDetailRepository userDetailRepository;

    @Autowired
    public UserCashRepository userCashRepository;

    Util util = new Util();
    
    
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    Logger log = LoggerFactory.getLogger(getClass().getName());


    //유저 정보저장
    @Transactional
    public void save(UserParam userParam) {

        //생성자
        UserMember userMember = new UserMember();
        UserMemberDetail userMemberDetail = new UserMemberDetail();
        UserCash userCash = new UserCash();

        //현재일자(yyyyMMdd)
        String nowDate = util.getTimeNow();
        
        // User 인스턴스
        userMember.setUserId(userParam.getUserId());
        userMember.setPassword(passwordEncoder.encode(userParam.getPassword()));
        userMember.setAdminYn(userParam.getAdminYn());
        userMember.setSaveStatus(userParam.getSaveStatus());
        userMember.setSignDate(nowDate);
        userMember.setModifyDate(nowDate);


        // UserMember 엔티티 저장
        userRepository.save(userMember);


        // UserMember 엔티티와 UserCash 엔티티 간의 연관관계 설정
        userCash.setUserMember(userMember);


        // userCash 인스턴스
        userCash.setAmount(0);
        userCash.setMileage(0);
        userCash.setAcmAmount(0);
        userCash.setAcmMileage(0);

        // userCash 엔티티 저장
        userCashRepository.save(userCash);

        // UserMember 엔티티와 UserMemberDetail 엔티티 간의 연관관계 설정
        userMemberDetail.setUserMember(userMember);

        // UserMemberDetail 인스턴스
        userMemberDetail.setSsn(userParam.getSsn1() + userParam.getSsn2());
        userMemberDetail.setName(userParam.getName());
        userMemberDetail.setGender(userParam.getGender());
        userMemberDetail.setSsn1(userParam.getSsn1());
        userMemberDetail.setSsn2(userParam.getSsn2());
        userMemberDetail.setPhone(userParam.getPhone1() + userParam.getPhone2() + userParam.getPhone3());
        userMemberDetail.setAddress(userParam.getAddress1() + userParam.getAddress2());
        userMemberDetail.setAddress1(userParam.getAddress1());
        userMemberDetail.setAddress2(userParam.getAddress2());
        userMemberDetail.setEmail(userParam.getEmail());
        userMemberDetail.setEmailYn(userParam.getEmail().isEmpty() ? "N" : "Y");
        userMemberDetail.setEmailDate(userParam.getEmailYn().equals("Y") ? nowDate : null);
        userMemberDetail.setPrivacyYn(userParam.getPrivacyYn());
        userMemberDetail.setPrivacyDate(userParam.getPrivacyYn().equals("Y") ? nowDate : null);
        userMemberDetail.setTransLevel("1");
        userMemberDetail.setTransPoint(0);
        userMemberDetail.setBankSeq(userParam.getBankSeq());
        userMemberDetail.setBankAccount(userParam.getBankAccount());

        // UserMemberDetail 엔티티 저장
        userDetailRepository.save(userMemberDetail);
    }

}
