package com.user.entity;

import com.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member"
        , uniqueConstraints = {
        @UniqueConstraint(columnNames = "member_no", name = "memberNo_pk"),
        @UniqueConstraint(columnNames = "memberId", name = "memberId_pk")
    }
)
@Getter
@Setter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "member_seq")
    @Column(name = "member_no", columnDefinition = "int not null comment '회원 고유번호'")
    private Long no;

    @Column(columnDefinition = "varchar(20) not null comment '아이디'")
    private String memberId;

    @Column(columnDefinition = "varchar(255) not null comment '패스워드'")
    private String password;

    @Column(columnDefinition = "varchar(1) default 'N' not null comment '관리자여부'")
    private String adminYn;
    @Column(columnDefinition = "varchar(1) default 'Y' not null comment '활성여부'")
    private String saveStatus;

    @JsonManagedReference
    @OneToOne(mappedBy = "member", optional = false, cascade = CascadeType.ALL)
    private MemberDetail memberDetail;

}

