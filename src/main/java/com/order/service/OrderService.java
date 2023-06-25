package com.order.service;

import com.order.dto.OrderDTO;
import com.order.repository.OrderRepository;
import com.user.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public static OrderDTO createOrderDTOToOrder(OrderDTO orderDTO, Member member) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String formatDateTime = now.format(formatter);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("O");
        stringBuilder.append(formatDateTime);

        OrderDTO order = new OrderDTO();
        order.setOrderNo(stringBuilder.toString());
//        order.setMember(member);
        order.setMemberEmail(orderDTO.getMemberEmail());
        order.setMemberPhone(orderDTO.getMemberPhone());
        order.setGoodsCode(orderDTO.getGoodsCode());
        order.setCostPrice(orderDTO.getCostPrice());
        order.setSalesPrice(orderDTO.getSalesPrice());
        order.setOrderLevel(orderDTO.getOrderLevel());

        return order;
    }

}
