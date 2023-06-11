package com.order.dto;

import com.common.entity.BaseEntity;
import lombok.Data;

@Data
public class OrderDTO extends BaseEntity {
    private Long no;
    private String orderNo;
    private String memberNo;
    private String memberEmail;
    private String memberPhone;
    private String gShortCode;
    private String orderLevel;
}
