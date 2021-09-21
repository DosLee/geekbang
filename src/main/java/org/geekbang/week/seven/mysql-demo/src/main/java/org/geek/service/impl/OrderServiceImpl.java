package org.geek.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.geek.domain.Order;
import org.geek.mapper.OrderMapper;
import org.geek.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 订单
 *
 * @author lil
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /**
     * 插入数据
     */
    @Override
    public int insertOrder() {
        List<Order> orders = asOrderList();
        long time = System.currentTimeMillis();
        log.info("对象生成完毕");
        // orders.parallelStream().forEach(orderMapper::insert);
        int i = orderMapper.batchInsert(orders);
        log.warn("插入数据用时: {} ms. jdbc返回影响条数: {}", (System.currentTimeMillis() - time), i);
        return i;
    }

    /**
     * 创建数据
     */
    private List<Order> asOrderList() {
        ArrayList<Order> orders = new ArrayList<>(1000001);
        for (int i = 0; i < 1000000; i++) {
            Order order = new Order();
            order.setId((long) i);
            order.setOrderId((long) i);
            order.setGoodsId(i);
            order.setUserId((long) i);
            orders.add(order);
        }
        return orders;
    }
}
