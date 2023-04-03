package com.neusoft.service;

import java.math.BigDecimal;


import com.neusoft.po.VirtualWallet;

public interface VirtualWalletService {
	public VirtualWallet getVirtualWallet(Integer walletId);
    public BigDecimal getBalance(Integer walletId);
    public int debit(Integer walletId, BigDecimal amount);
    public int credit(Integer walletId, BigDecimal amount);
    public int transfer(Integer fromWalletId, Integer toWalletId, BigDecimal amount,Integer orderId);

    public VirtualWallet getVirtualWalletByUserId(String userId);
    
}
