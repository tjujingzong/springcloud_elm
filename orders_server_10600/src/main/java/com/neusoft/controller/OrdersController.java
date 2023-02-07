package com.neusoft.controller;

import com.neusoft.po.CommonResult;
import com.neusoft.po.Orders;
import com.neusoft.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author：ljz
 * @Date：2022/9/12 13:28
 * @Description:
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/Orders")
public class OrdersController {
    @Autowired

    private OrdersService ordersService;

    @PostMapping("/OrdersId")
    public CommonResult<Integer> createOrders(Orders orders) throws Exception {
        return new CommonResult<>(200, "success", ordersService.createOrders(orders));
    }

    @GetMapping("/OrdersId")
    public CommonResult<Orders> getOrderById(Orders orders) throws Exception {
        return new CommonResult<>(200, "success", ordersService.getOrdersById(orders.getOrderId()));
    }

    @GetMapping("/UserId")
    public CommonResult<List> listOrdersByUserId(Orders orders) throws Exception {
        return new CommonResult<>(200, "success", ordersService.listOrdersByUserId(orders.getUserId()));
    }
}