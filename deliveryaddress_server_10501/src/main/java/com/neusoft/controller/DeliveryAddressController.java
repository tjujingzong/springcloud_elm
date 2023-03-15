package com.neusoft.controller;

import com.neusoft.po.CommonResult;
import com.neusoft.po.DeliveryAddress;
import com.neusoft.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author：ljz
 * @Date：2022/9/12 11:08
 * @Description:
 */


@RestController
@RequestMapping("/DeliveryAddress")
public class DeliveryAddressController {
    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @GetMapping("/UserId")
    public CommonResult<List> listDeliveryAddressByUserId(DeliveryAddress deliveryAddress)
            throws Exception {
        return new CommonResult<List>(200, "success",
                deliveryAddressService.listDeliveryAddressByUserId(deliveryAddress.getUserId()));
    }

    @GetMapping("/DaId")
    public CommonResult<DeliveryAddress> getDeliveryAddressById(DeliveryAddress deliveryAddress) throws
            Exception {
        return new CommonResult<DeliveryAddress>(200, "success",
                deliveryAddressService.getDeliveryAddressById(deliveryAddress.getDaId()));
    }

    @PostMapping("/DaId")
    public CommonResult<Integer> saveDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        return new CommonResult<Integer>(200, "success",
                deliveryAddressService.saveDeliveryAddress(deliveryAddress));
    }

    @PutMapping("/DaId")
    public CommonResult<Integer> updateDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        return new CommonResult<Integer>(200, "success",
                deliveryAddressService.updateDeliveryAddress(deliveryAddress));
    }

    @DeleteMapping("/DaId")
    public CommonResult<Integer> removeDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        return new CommonResult<Integer>(200, "success",
                deliveryAddressService.removeDeliveryAddress(deliveryAddress.getDaId()));
    }
}