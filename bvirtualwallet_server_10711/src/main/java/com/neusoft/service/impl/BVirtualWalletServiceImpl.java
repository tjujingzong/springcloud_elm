package com.neusoft.service.impl;

import com.neusoft.mapper.BVirtualWalletMapper;
import com.neusoft.po.BVirtualWallet;
import com.neusoft.service.BVirtualWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BVirtualWalletServiceImpl implements BVirtualWalletService {
    @Autowired
    private BVirtualWalletMapper bVirtualWalletMapper;


    @Override
    public BVirtualWallet getVirtualWalletByBusinessId(Integer businessId) {
        return bVirtualWalletMapper.getVirtualWalletByBusinessId(businessId);
    }
}

