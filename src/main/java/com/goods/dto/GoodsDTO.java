package com.goods.dto;

import com.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GoodsDTO extends BaseEntity {
    private Long no;
    private String productName;
    private String kind;
    private Integer costPrice;
    private Integer salesPrice;
    private Integer profitPrice;
    private String content;
    private String limitedTimeOffer;
    private String image;
    private String useYn;

}
