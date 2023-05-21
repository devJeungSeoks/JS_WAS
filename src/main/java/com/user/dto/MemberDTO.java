package com.user.dto;

import com.common.entity.BaseEntity;
import lombok.Data;

@Data
public class MemberDTO extends BaseEntity {
//    private Long no;
    private String memberId;
    private String password;
    private String adminYn;
    private String saveStatus;
    private String memberName;
    private String ssn;
    private String ssn1;
    private String ssn2;
    private String phone;
    private String bankSeq;
    private String bankAccount;
    private String gender;
    private String address;
    private String address1;
    private String address2;
    private String zipCode;
    private int transPoint;
    private String transLevel;
    private String email;

}
