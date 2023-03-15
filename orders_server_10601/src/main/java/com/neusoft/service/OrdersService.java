package com.neusoft.service;

import com.neusoft.po.Orders;

import java.util.List;

/**
 * @Author：ljz
 * @Date：2022/9/12 12:40
 * @Description:
 */
public interface OrdersService {
    public int createOrders(Orders orders);

    public Orders getOrdersById(Integer orderId);

    public List<Orders> listOrdersByUserId(String userId);
}
