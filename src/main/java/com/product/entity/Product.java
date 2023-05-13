package com.product.entity;

import com.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "product_seq")
    @Column(name = "no", columnDefinition = "int not null comment '상품 고유번호'")
    private Long no;

    @Column(columnDefinition = "varchar(20) not null comment '상품명'")
    private String productName;

    @Column(columnDefinition = "char(1) not null comment '상품종류(bag : 1, wallet : 2, shoes :3, acc : 4)'")
    private String kind;

    @Column(name = "price1", columnDefinition = "int not null comment '원가'")
    private int price1;
    @Column(name = "price2", columnDefinition = "int not null comment '판매가'")
    private int price2;
    @Column(name = "price3", columnDefinition = "int not null comment '이익'")
    private int price3;

    @Column(columnDefinition = "varchar(1000) null comment '상품설명'")
    private String content;

    @Column(columnDefinition = "varchar(200) null comment '상품사진'")
    private String image;

    @Column(name = "useYn", columnDefinition = "varchar(200) not null comment '판매유무'")
    private String useYn;


}
