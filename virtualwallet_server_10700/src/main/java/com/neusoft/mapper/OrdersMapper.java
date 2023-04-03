package com.neusoft.mapper;

import com.neusoft.po.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author：ljz
 * @Date：2022/9/12 12:48
 * @Description: 这里参考pdf里给错了
 */
@Mapper
public interface OrdersMapper {
    @Insert("insert into orders(userId,businessId,orderDate,orderTotal,daId,orderState) values(#{userId},#{businessId},#{orderDate},#{orderTotal},#{daId},0)")
    @Options(useGeneratedKeys = true, keyProperty = "orderId", keyColumn = "orderId")
    public int saveOrders(Orders orders);

    public Orders getOrdersById(Integer orderId);

    public List<Orders> listOrdersByUserId(String userId);

    @Update("update orders set orderState=1 where orderId=#{orderId}")
    public int updateOrderState(Integer orderId);
}
