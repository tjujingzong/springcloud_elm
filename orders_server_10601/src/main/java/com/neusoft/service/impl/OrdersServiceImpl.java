package com.neusoft.service.impl;

import com.neusoft.mapper.CartMapper;
import com.neusoft.mapper.OrderDetailetMapper;
import com.neusoft.mapper.OrdersMapper;
import com.neusoft.po.Cart;
import com.neusoft.po.OrderDetailet;
import com.neusoft.po.Orders;
import com.neusoft.service.OrdersService;
import com.neusoft.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：ljz
 * @Date：2022/9/12 12:40
 * @Description:
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailetMapper orderDetailetMapper;

    @Override
    @Transactional
    public int createOrders(Orders orders) {//只需一行注释就可实现事务管理 @Transactional
        //1、查询当前用户购物车中当前商家的所有食品
        Cart cart = new Cart();//封装一下
        cart.setUserId(orders.getUserId());
        cart.setBusinessId(orders.getBusinessId());
        List<Cart> cartList = cartMapper.listCart(cart);


        //2、创建订单（返回生成的订单编号）
        orders.setOrderDate(CommonUtil.getCurrentDate());
        ordersMapper.saveOrders(orders);
        int orderId = orders.getOrderId();//返回的是获取的主键

        //3、批量添加订单明细
        List<OrderDetailet> list = new ArrayList<>();
        for (Cart c : cartList) {
            OrderDetailet od = new OrderDetailet();
            od.setOrderId(orderId);
            od.setFoodId(c.getFoodId());
            od.setQuantity(c.getQuantity());
            list.add(od);
        }

        orderDetailetMapper.saveOrderDetailetBatch(list);

        //4、从购物车表中删除相关食品信息
        cartMapper.removeCart(cart);

        return orderId;
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        return ordersMapper.getOrdersById(orderId);
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        return ordersMapper.listOrdersByUserId(userId);
    }
}
