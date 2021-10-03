package org.geek.rpcfx.service;


import org.geek.rpcfx.pojo.Order;

/**
 * 描述:
 *
 * @author lil
 */
public interface OrderService {
    Order findOrderById(Integer id);
}
