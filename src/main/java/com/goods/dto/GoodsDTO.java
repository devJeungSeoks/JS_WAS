package com.goods.dto;

import lombok.Data;

@Data
public class GoodsDTO {
    private Long no;
    private String productName;
    private String kind;
    private int price1;
    private int price2;
    private int price3;
    private String content;
    private String image;
    private String useYn;

}
