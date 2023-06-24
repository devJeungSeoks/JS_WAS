package com.order.controller;

import com.config.jwt.JwtTokenProvider;
import com.order.dto.OrderDTO;
import com.order.service.OrderService;
import com.user.entity.Member;
import com.user.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {


    @Autowired
    MemberRepository memberRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/create")
    public String createOrder(
//    public void createOrder(
            @RequestBody OrderDTO orderDTO,
            HttpServletRequest request
    ) {
        log.debug("주문 전송 데이터 : " + orderDTO);
        String token = jwtTokenProvider.resolveToken(request);

        System.out.println("aaaaaa : " + jwtTokenProvider.getUserPk(token));
        System.out.println("ㅠㅠㅠㅠ : " + jwtTokenProvider.getAuthentication(token).getPrincipal());

        String return_msg = "";
        if (jwtTokenProvider.validateToken(token) == true && !orderDTO.getGoodsCode().isEmpty()) {
            Member member = (Member) jwtTokenProvider.getAuthentication(token).getPrincipal();
//            OrderDTO order = orderService.createOrderDTOToOrder(orderDTO, member);
//            System.out.println("sss : " + order);

            System.out.println("member : " + member);

        } else {
            return_msg = "false";
        }


        return return_msg;
    }
}
