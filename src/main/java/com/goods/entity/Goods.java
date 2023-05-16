package com.goods.entity;

import com.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Goods extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no", columnDefinition = "int not null comment '상품 고유번호'")
    private Long no;

    @Column(columnDefinition = "varchar(20) not null comment '상품명'")
    private String productName;

    @Column(columnDefinition = "char(1) not null comment '상품종류'")
    private String kind;

    @Column(name = "costPrice", columnDefinition = "int not null comment '원가'")
    private int costPrice;
    @Column(name = "salesPrice", columnDefinition = "int not null comment '판매가'")
    private int salesPrice;
    @Column(name = "profitPrice", columnDefinition = "int not null comment '이익'")
    private int profitPrice;

    @Column(columnDefinition = "varchar(1000) null comment '상품설명'")
    private String content;
    @Column(columnDefinition = "varchar(255) null comment '할인특가명'")
    private String limitedTimeOffer;

    @Column(columnDefinition = "varchar(200) null comment '상품사진'")
    private String image;

    @Column(name = "use_yn", columnDefinition = "varchar(1) not null comment '판매유무'")
    private String useYn;


}
