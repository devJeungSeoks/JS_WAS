package com.order.entity;

import com.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.user.entity.Member;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "orders", uniqueConstraints = {@UniqueConstraint(columnNames = {"orderNo"}, name = "orderNo")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "order_seq")
    @Comment("고유번호")
    private Long no;

    @Column(nullable = false, length = 20)
    @Comment("주문번호")
    private String orderNo;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNo")
    private Member member;

    @Column(nullable = false, length = 50)
    @Comment("주문자 이메일")
    private String memberEmail;

    @Column(nullable = false, length = 20)
    @Comment("주문자 번호")
    private String memberPhone;

    @Column(nullable = false, length = 20)
    @Comment("상품코드")
    private String goodsCode;

    @Column(nullable = false, name = "costPrice")
    @Comment("원가")
    private Integer costPrice;
    @Column(nullable = false, name = "salesPrice")
    @Comment("판매가")
    private Integer salesPrice;

    @Column(nullable = false, length = 1)
    @ColumnDefault("'1'")
    @Comment("주문상태(1: 대기, 2: 주문승인, 3: 결제대기, 4: 배송대기, 5:배송 준비중, 6: 배송중, 7: 배송완료, 8: 결제완료)")
    private String orderLevel;
}

