package com.goods.dto;

import com.common.entity.BaseEntity;
import lombok.Data;

@Data
public class GoodsDTO extends BaseEntity {
    private Long no;
    private String productName;
    private String kind;
    private int costPrice;
    private int salesPrice;
    private int profitPrice;
    private String content;
    private String limitedTimeOffer;
    private String image;
    private String useYn;

}
