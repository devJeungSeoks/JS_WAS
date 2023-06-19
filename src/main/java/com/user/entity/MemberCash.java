package com.user.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MemberCash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("고유번호")
    private Long no;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNo", unique = true)
    @Comment("회원 고유번호")
    private Member member;

    @Comment("잔액")
    @ColumnDefault("0")
    private int amount;

    @Comment("마일리지")
    @ColumnDefault("0")
    private int mileage;

    @Comment("누적잔액")
    @ColumnDefault("0")
    private int acmAmount;

    @Comment("누적 마일리지")
    @ColumnDefault("0")
    private int acmMileage;

}
