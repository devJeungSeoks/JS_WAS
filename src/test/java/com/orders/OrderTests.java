package com.orders;

import com.order.dto.OrderDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@SpringBootTest
public class OrderTests {
    @Test
    public void createTest(){
        OrderDTO orderDTO = new OrderDTO();
        System.out.println("toString : " + orderDTO.toString());

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String formatDateTime = now.format(formatter);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("O");
        stringBuilder.append(formatDateTime);
//
//        orderDTO.setOrderNo(stringBuilder.toString());
//        orderDTO.setMemberNo(1L);
//        orderDTO.setMemberEmail("dks2922@naver.com");
//        orderDTO.setMemberPhone("01034340069");
//        orderDTO.setGoodsCode("2058");
//        orderDTO.setOrderLevel("TEST입니다.");
//

        System.out.println("orderDTO : " + orderDTO);

    }
}
