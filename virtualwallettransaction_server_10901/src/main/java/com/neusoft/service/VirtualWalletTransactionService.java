package com.neusoft.service;

import com.neusoft.po.VirtualWalletTransaction;

import java.util.List;

public interface VirtualWalletTransactionService {
	
	public int saveTransaction(VirtualWalletTransaction transaction);//插入交易记录
	public List<VirtualWalletTransaction> listTransactionBywalletId(Integer walletId);//查询历史记录

	
}
