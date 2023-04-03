package com.neusoft.service;


import com.neusoft.po.BVirtualWallet;

public interface BVirtualWalletService {
    public BVirtualWallet getVirtualWalletByBusinessId(Integer businessId);
}
