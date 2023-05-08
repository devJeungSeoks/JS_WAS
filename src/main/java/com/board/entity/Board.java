package com.board.entity;

import com.common.entity.BaseEntity;
import com.user.entity.UserMember;

import javax.persistence.*;

@Entity
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null comment '고유번호'")
    private Long no;

    @Column(columnDefinition = "varchar(20) not null comment '거래번호'")
    private String transNo;

    @Column(columnDefinition = "varchar(20) not null comment '종류'")
    private String kind;

    @Column(columnDefinition = "varchar(100) not null comment '제목'")
    private String title;

    @Column(columnDefinition = "longtext null comment '내용'")
    private String contents;

    @ManyToOne(targetEntity = UserMember.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo")
    private UserMember userMember;

}
