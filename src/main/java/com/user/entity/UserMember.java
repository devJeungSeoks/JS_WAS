package com.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "USER_MEMBER", uniqueConstraints = {
        @UniqueConstraint(
                name = "ID_UNIQUE"
                , columnNames = {"userId"}
        )
})
@ToString
public class UserMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "USERMEMBER_GENERATOR")
    @Column(columnDefinition = "int not null comment '유저 고유번호'")
    private Long userNo;

    @Column(columnDefinition = "varchar(20) not null comment '아이디'")
    private String userId;

    @Column(columnDefinition = "varchar(255) not null comment '패스워드'")
    private String password;

    @Column(columnDefinition = "varchar(1) not null comment '관리자여부'")
    private String adminYn;
    @Column(columnDefinition = "varchar(1) not null comment '활성여부'")
    private String saveStatus;

    @Column(columnDefinition = "varchar(8) not null comment '가입날짜'")
    private String signDate;
    @Column(columnDefinition = "varchar(8) not null comment '정보수정 날짜'")
    private String modifyDate;


    @OneToOne(mappedBy = "userMember")
    private UserMemberDetail userMemberDetails;

}

