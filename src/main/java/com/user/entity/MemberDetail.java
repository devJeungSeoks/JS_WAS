package com.user.entity;

import com.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "memberDetail")
@Getter
@Setter
public class MemberDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "memberDetail_seq")
    @Comment("고유번호")
    private Long no;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNo")
    private Member member;

    @Column(length = 20, nullable = false)
    @Comment("유저명")
    private String memberName;

    @Column(length = 13, nullable = false)
    @Comment("주민번호")
    private String ssn;

    @Column(length = 6, nullable = false)
    @Comment("주민번호(앞자리)")
    private String ssn1;

    @Column(length = 7, nullable = false)
    @Comment("주민번호(뒷자리)")
    private String ssn2;

    @Column(length = 11)
    @Comment("휴대폰 번호")
    private String phone;

    @Column(length = 3)
    @Comment("은행 코드")
    private String bankSeq;
    @Column(length = 20)
    @Comment("계좌번호")
    private String bankAccount;

    @Column(length = 1, nullable = false)
    @Comment("성별")
    private String gender;
    @Column(length = 100)
    @Comment("통합 주소")
    private String address;
    @Column(length = 40)
    @Comment("사는곳")
    private String address1;
    @Column(length = 60)
    @Comment("상세주소")
    private String address2;

    @Column(length = 5)
    @Comment("우편번호")
    private String zipCode;

    @Column(nullable = false)
    @Comment("거래점수")
    private int transPoint;
    @Column(nullable = false)
    @Comment("거래레벨")
    @ColumnDefault("B")
    private String transLevel;

    @Column(length = 40)
    @Comment("이메일")
    private String email;

    @Column(nullable = false)
    @Comment("개인정보 동의여부")
    private String privacyPolicy;
    @Column(nullable = false)
    @Comment("마케팅 동의여부")
    private String allowPromotions;
    @Column(nullable = false)
    @Comment("자사 이용약관 동의여부")
    private String termsOfService;

}
