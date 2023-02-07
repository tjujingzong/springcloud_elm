package com.neusoft.controller;

import com.neusoft.po.Business;
import com.neusoft.po.CommonResult;
import com.neusoft.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author：ljz
 * @Date：2022/9/6 19:36
 * @Description:
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/Business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();//这里感觉用不到

    @GetMapping("/OrderTypeId")
    public CommonResult<List> listBusinessByOrderTypeId(Business business) throws Exception {
        return new CommonResult<List>(200, "success",
                businessService.listBusinessByOrderTypeId(business.getOrderTypeId()));
    }

    @GetMapping("/BusinessId")
    public CommonResult<Business> getBusinessById(Business business) throws Exception {
        return new CommonResult<Business>(200, "success",
                businessService.getBusinessById(business.getBusinessId()));
    }
}
