package com.order.dto;

import com.common.entity.BaseEntity;
import lombok.Data;

@Data
public class OrderDTO extends BaseEntity {
    private Long no;
    private String orderNo;
    private Long memberNo;
    private String memberEmail;
    private String memberPhone;
    private String goodsCode;
    private String orderLevel;
    private Integer costPrice;
    private Integer salesPrice;
//    private Member member;
}
