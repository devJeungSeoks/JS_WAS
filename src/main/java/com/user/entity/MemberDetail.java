package com.user.entity;

import com.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "memberDetail")
@Getter
@Setter
public class MemberDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "memberDetail_seq")
    @Column(columnDefinition = "int not null comment '유저 고유번호'")
    private Long no;

    @OneToOne
    @JoinColumn(name = "member_no")
    private Member member;

    @Column(columnDefinition = "varchar(20) not null comment '이름'")
    private String memberName;

    @Column(columnDefinition = "varchar(13) not null comment '주민번호'")
    private String ssn;

    @Column(columnDefinition = "varchar(6) not null comment '주민번호(앞자리)'")
    private String ssn1;

    @Column(columnDefinition = "varchar(7) not null comment '주민번호(뒷자리)'")
    private String ssn2;

    @Column(columnDefinition = "varchar(11) null comment '휴대폰 번호'")
    private String phone;

    @Column(columnDefinition = "varchar(3) null comment '은행 코드'")
    private String bankSeq;
    @Column(columnDefinition = "varchar(20) null comment '계좌번호'")
    private String bankAccount;

    @Column(columnDefinition = "varchar(1) not null comment '성별'")
    private String gender;
    @Column(columnDefinition = "varchar(100) null comment '통합 주소'")
    private String address;
    @Column(columnDefinition = "varchar(40) null comment '사는곳'")
    private String address1;
    @Column(columnDefinition = "varchar(60) null comment '상세주소'")
    private String address2;

    @Column(columnDefinition = "varchar(5) null comment '우편번호'")
    private String zipCode;

    @Column(columnDefinition = "int not null comment '거래점수'")
    private int transPoint;
    @Column(columnDefinition = "varchar(1) not null comment '거래 레벨'")
    private String transLevel;

    @Column(columnDefinition = "varchar(40) null comment '이메일'")
    private String email;


}
