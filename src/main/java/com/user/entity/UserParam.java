package com.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class UserParam {


    private UserMember userMember;
    private String userId;
    private String password;
    private String adminYn;
    private String saveStatus;
    private String signDate;
    private String modifyDate;
    private String name;
    private String ssn;
    private String ssn1;
    private String ssn2;
    private String phone1;
    private String phone2;
    private String phone3;
    private String phone;
    private String bankSeq;
    private String bankAccount;
    private String gender;
    private String address;
    private String address1;
    private String address2;

    private int transPoint;
    private String transLevel;

    private String privacyYn;
    private String privacyDate;
    private String email;
    private String email1;
    private String email2;
    private String emailYn;
    private String emailDate;


    private int amount;
    private int mileage;
    private int acmAmount;
    private int acmMileage;


    public UserParam(
            UserMember userMember
            , String userId
            , String password
            , String adminYn
            , String saveStatus
            , String signDate
            , String modifyDate
            , String name
            , String ssn
            , String ssn1
            , String ssn2
            , String phone1
            , String phone2
            , String phone3
            , String phone
            , String bankSeq
            , String bankAccount
            , String gender
            , String address
            , String address1
            , String address2
            , String privacyYn
            , String privacyDate
            , String email
            , String email1
            , String email2
            , String emailYn
            , String emailDate
    ) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        //현재일자
        String getDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//
//        StringBuilder sb = new StringBuilder();
//
//        System.out.println("====================================================");
//        //UserMember
//        //패스워드 인코드
//        this.password = passwordEncoder.encode(password);
//        System.out.println("1111111111111111111111111111");
        setModifyDate(getDate);
        this.signDate = getDate;
//        System.out.println("2222222222222222222222222222");
//
////
//        //UserMemberDetail
//        this.phone = sb.append(this.getPhone1()).append(this.getPhone2()).append(this.getPhone3()).toString();
//        this.address = sb.append(this.getAddress1()).append(this.getAddress2()).toString();
//        this.ssn = sb.append(this.getSsn1()).append(this.getSsn2()).toString();
//        this.email = sb.append(this.getEmail1()).append(this.getEmail2()).toString();
//        this.emailYn = this.getEmail().isEmpty() ? "Y" : "N";
//        this.emailDate = this.emailYn.equals("Y") ? getDate : null;
//        this.privacyDate = this.getPrivacyYn().equals("Y") ? getDate : null;





        this.userMember = userMember;
        this.userId = userId;
        this.password = passwordEncoder.encode(password);
        this.adminYn = adminYn;
        this.saveStatus = saveStatus;
//        this.signDate = signDate;
//        this.modifyDate = modifyDate;
        this.name = name;
        this.ssn = ssn;
        this.ssn1 = ssn1;
        this.ssn2 = ssn2;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.phone = phone;
        this.bankSeq = bankSeq;
        this.bankAccount = bankAccount;
        this.gender = gender;
        this.address = address;
        this.address1 = address1;
        this.address2 = address2;
        this.privacyYn = privacyYn;
        this.privacyDate = privacyDate;
        this.email = email;
        this.email1 = email1;
        this.email2 = email2;
        this.emailYn = emailYn;
        this.emailDate = emailDate;
















    }

}
