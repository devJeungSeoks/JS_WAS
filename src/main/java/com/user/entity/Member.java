package com.user.entity;

import com.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter @Setter
@ToString
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "member_seq")
    @Column(name = "member_no", columnDefinition = "int not null comment '유저 고유번호'")
    private Long no;

    @Column(columnDefinition = "varchar(20) not null comment '아이디'")
    private String memberId;

    @Column(columnDefinition = "varchar(255) not null comment '패스워드'")
    private String password;

    @Column(columnDefinition = "varchar(1) not null comment '관리자여부'")
    private String adminYn;
    @Column(columnDefinition = "varchar(1) not null comment '활성여부'")
    private String saveStatus;

    @OneToOne(mappedBy = "member", optional = false)
    private MemberDetail memberDetail;

}

