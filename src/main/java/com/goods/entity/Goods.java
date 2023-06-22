package com.goods.entity;

import com.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Goods extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no", nullable = false)
    @Comment("고유번호")
    private Long no;

    @Column(length = 20, nullable = false, unique = true)
    @Comment("상품코드")
    private String goodsCode;

    @Column(length = 20, nullable = false)
    @Comment("상품명")
    private String productName;

    @Column(nullable = false)
    @Comment("상품종류")
    private String kind;

    @Column(name = "costPrice", nullable = false)
    @Comment("원가")
    private Integer costPrice;
    @Column(name = "salesPrice", nullable = false)
    @Comment("판매가")
    private Integer salesPrice;
    @Column(name = "profitPrice", nullable = false)
    @Comment("이익")
    private Integer profitPrice;

    @Column(length = 1000, nullable = false)
    @Comment("상품설명")
    private String content;
    @Column(length = 255, nullable = false)
    @Comment("할인특가명")
    private String limitedTimeOffer;

    @Column(length = 200, nullable = false)
    @Comment("상품사진")
    private String image;

    @Column(length = 1, name = "use_yn", nullable = false)
    @Comment("판매유무")
    private String useYn;


}
