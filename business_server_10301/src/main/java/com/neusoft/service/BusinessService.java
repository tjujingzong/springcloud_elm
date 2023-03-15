package com.neusoft.service;

/**
 * @Author：ljz
 * @Date：2022/9/6 19:29
 * @Description:
 */

import com.neusoft.po.Business;

import java.util.List;

public interface BusinessService {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);
    public Business getBusinessById(Integer businessId);
}
