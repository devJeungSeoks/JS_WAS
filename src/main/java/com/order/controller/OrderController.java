package com.order.controller;

import com.order.dto.OrderDTO;
import com.order.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public void orderCreate(@RequestBody OrderDTO orderDTO) {
        log.debug("주문 전송 데이터 : " + orderDTO);
        orderService.orderCreate(orderDTO);
    }
}
