package com.neusoft.service.impl;

import com.neusoft.mapper.VirtualWalletTransactionMapper;
import com.neusoft.po.VirtualWalletTransaction;
import com.neusoft.service.VirtualWalletTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VirtualWalletTransactionServiceImpl implements VirtualWalletTransactionService {
    @Autowired
    private  VirtualWalletTransactionMapper transactionMapper;
  
	@Override
	public int saveTransaction(VirtualWalletTransaction transaction) {
		return transactionMapper.saveTransaction(transaction);
	}

	@Override
	public List<VirtualWalletTransaction> listTransactionBywalletId(Integer walletId) {
		
		return transactionMapper.listTransactionBywalletId(walletId) ;
	}

}
