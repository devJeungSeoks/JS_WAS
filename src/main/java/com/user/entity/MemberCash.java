package com.user.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "userCash")
public class MemberCash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("고유번호")
    private Long no;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNo")
    private Member member;

    @Column(nullable = false)
    @Comment("잔액")
    private int amount;

    @Column(nullable = false)
    @Comment("마일리지")
    private int mileage;

    @Column(nullable = false)
    @Comment("누적잔액")
    private int acmAmount;

    @Column(nullable = false)
    @Comment("누적 마일리지")
    private int acmMileage;

}
