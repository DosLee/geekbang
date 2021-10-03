package org.geek.rpcfx;

import org.geek.rpcfx.pojo.Order;
import org.geek.rpcfx.service.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(Integer id) {
        return new Order(id, "apple" + System.currentTimeMillis());
    }
}
