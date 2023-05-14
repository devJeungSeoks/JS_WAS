package com.user.entity;


import lombok.*;

import javax.persistence.*;

//@Entity
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
public class UserCash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null comment '고유번호'")
    private Long no;

//    @ManyToOne(targetEntity = UserMember.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "userNo")
//    private UserMember userMember;

    @Column(columnDefinition = "int not null comment '잔액'")
    private int amount;

    @Column(columnDefinition = "int not null comment '마일리지'")
    private int mileage;

    @Column(columnDefinition = "int not null comment '누적잔액'")
    private int acmAmount;

    @Column(columnDefinition = "int not null comment '누적 마일리지'")
    private int acmMileage;

}
