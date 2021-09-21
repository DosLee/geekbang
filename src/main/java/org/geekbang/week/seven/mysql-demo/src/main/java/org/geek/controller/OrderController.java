package org.geek.controller;

import lombok.extern.slf4j.Slf4j;
import org.geek.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 订单Order
 *
 * @author lil
 */
@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 创建订单
     */
    @PostMapping("create")
    public String orderCreate() {
       return orderService.insertOrder() > 0 ? "successful" : "failed";
    }

}
