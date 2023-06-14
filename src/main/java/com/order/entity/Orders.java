package com.order.entity;

import com.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.user.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"orderNo"}, name = "orderNo")
        })
@Getter
@Setter
public class Orders extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "order_seq")
    private Long no;

    @Column(columnDefinition = "varchar(20) not null comment '주문번호'")
    private String orderNo;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNo")
    private Member member;

    @Column(columnDefinition = "varchar(50) not null comment '주문자 이메일'")
    private String memberEmail;

    @Column(columnDefinition = "varchar(20) not null comment '주문자 번호'")
    private String memberPhone;

    @Column(columnDefinition = "varchar(20) not null comment '상품코드'")
    private String goodsCode;

    @Column(name = "costPrice", columnDefinition = "int not null comment '원가'")
    private int costPrice;
    @Column(name = "salesPrice", columnDefinition = "int not null comment '판매가'")
    private int salesPrice;

    @Column(columnDefinition = "varchar(1) default '1' not null comment '주문상태(1: 대기, 2: 주문승인, 3: 결제대기, 4: 배송대기, 5:배송 준비중, 6: 배송중, 7: 배송완료, 8: 결제완료)'")
    private String orderLevel;
}

