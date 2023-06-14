package com.order.service;

import com.order.dto.OrderDTO;
import com.order.entity.Orders;
import com.order.repository.OrderRepository;
import com.user.entity.Member;
import com.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
@RequiredArgsConstructor
@Log4j2
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MemberService memberService;

    /**
     * 주문
     *
     * @param orderDto
     */
    public void orderCreate(OrderDTO orderDto) {

        try {

            // Order, member 객체 생성 및 필드 설정
            Orders orders = createOrderFromDto(orderDto);
            log.debug("주문 DTO -> Order Entity 객체화 : " + orders);

            Member member = memberService.memberSelect(orderDto.getMemberNo());
            log.debug("회원조회 member : " + member);

            // 관계 설정
            orders.setMember(member);

            log.debug("최종 Entity Data : " + orders);
            // Order 을 저장합니다.
            orderRepository.save(orders);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 주문 객체
     *
     * @param orderDTO
     * @return
     */
    private Orders createOrderFromDto(OrderDTO orderDTO) {

        Orders orders = new Orders();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String formatDateTime = now.format(formatter);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("O");
        stringBuilder.append(formatDateTime);

        orders.setOrderNo(stringBuilder.toString());
        orders.setMemberEmail(orderDTO.getMemberEmail());
        orders.setMemberPhone(orderDTO.getMemberPhone());
        orders.setGoodsCode(orderDTO.getGoodsCode());
        orders.setOrderLevel(orderDTO.getOrderLevel());
        orders.setCostPrice(orderDTO.getCostPrice());
        orders.setSalesPrice(orderDTO.getSalesPrice());

        return orders;
    }

}
