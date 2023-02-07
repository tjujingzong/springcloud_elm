package com.neusoft.service.impl;

import com.neusoft.mapper.BusinessMapper;
import com.neusoft.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neusoft.po.Business;

import java.util.List;

/**
 * @Author：ljz
 * @Date：2022/9/6 19:32
 * @Description:
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    protected BusinessMapper businessMapper;

    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        return businessMapper.listBusinessByOrderTypeId(orderTypeId);
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        return businessMapper.getBusinessById(businessId);
    }
}
