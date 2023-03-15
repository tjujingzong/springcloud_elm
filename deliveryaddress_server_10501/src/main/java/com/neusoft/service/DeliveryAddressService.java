package com.neusoft.service;

/**
 * @Author：ljz
 * @Date：2022/9/12 11:04
 * @Description:
 */

import com.neusoft.po.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);

    public DeliveryAddress getDeliveryAddressById(Integer daId);

    public int saveDeliveryAddress(DeliveryAddress deliveryAddress);

    public int updateDeliveryAddress(DeliveryAddress deliveryAddress);

    public int removeDeliveryAddress(Integer daId);
}
