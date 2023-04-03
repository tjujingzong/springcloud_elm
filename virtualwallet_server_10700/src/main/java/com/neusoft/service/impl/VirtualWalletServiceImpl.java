package com.neusoft.service.impl;

import java.math.BigDecimal;

import com.neusoft.mapper.BVirtualWalletMapper;
import com.neusoft.mapper.OrdersMapper;
import com.neusoft.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.constants.TransactionStatus;
import com.neusoft.mapper.VirtualWalletMapper;
import com.neusoft.mapper.VirtualWalletTransactionMapper;
import com.neusoft.service.VirtualWalletService;

@Service
public class VirtualWalletServiceImpl implements VirtualWalletService {
	@Autowired
	private VirtualWalletMapper virtualWalletMapper;
	@Autowired
	private VirtualWalletTransactionMapper transactionMapper;
	@Autowired
	private BVirtualWalletMapper bvirtualWalletMapper;

	@Autowired
	private OrdersMapper ordersMapper;

	@Override
	public VirtualWallet getVirtualWalletByUserId(String userId) {
		return virtualWalletMapper.getVirtualWalletByUserId(userId);
	}

	@Override
	public VirtualWallet getVirtualWallet(Integer walletId) {

		return virtualWalletMapper.getVirtualWallet(walletId);
	}

	@Override
	public BigDecimal getBalance(Integer walletId) {

		return virtualWalletMapper.getBalance(walletId);
	}

	//提现
	@Override
	public int debit(Integer walletId, BigDecimal amount) {
		VirtualWallet wallet = virtualWalletMapper.getVirtualWallet(walletId);
		try {
			wallet.debit(amount);
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
			return 0;
		}
		virtualWalletMapper.updateBalance(walletId, wallet.balance());

		VirtualWalletTransaction transaction = new VirtualWalletTransaction();

		transaction.setAmount(amount);
		transaction.setWalletId(walletId);
		transaction.setFromWalletId(walletId);
		transaction.setToWalletId(null);
		transaction.setStatus(TransactionStatus.DEBIT);
		int result=transactionMapper.saveTransaction(transaction);
		return result;

	}

	//充值
	@Override
	public int credit(Integer walletId, BigDecimal amount) {
		VirtualWallet wallet = virtualWalletMapper.getVirtualWallet(walletId);
		BigDecimal balance=virtualWalletMapper.getBalance(walletId);
		try {
			wallet.credit(amount);
		} catch (InvalidAmountException e) {
			e.printStackTrace();
			return 0;
		}

		virtualWalletMapper.updateBalance(walletId,balance);

		VirtualWalletTransaction transaction = new VirtualWalletTransaction();

		transaction.setAmount(amount);
		transaction.setWalletId(walletId);
		transaction.setFromWalletId(null);
		transaction.setToWalletId(walletId);
		transaction.setStatus(TransactionStatus.CREDIT);
		int result=transactionMapper.saveTransaction(transaction);
		return result;
	}

	//支付
	@Override
	public int transfer(Integer fromWalletId, Integer toWalletId, BigDecimal amount, Integer orderId) {
		VirtualWallet fromwallet = virtualWalletMapper.getVirtualWallet(fromWalletId);
		BVirtualWallet towallet = bvirtualWalletMapper.getVirtualWallet(toWalletId);
        int result=0;
		try {
			fromwallet.debit(amount);
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
            return 0;
		}

		try {
			towallet.credit(amount);
		} catch (InvalidAmountException e) {
			e.printStackTrace();
			return 0;
		}

		virtualWalletMapper.updateBalance(fromWalletId, fromwallet.balance());
		bvirtualWalletMapper.updateBalance(toWalletId, towallet.balance());

		VirtualWalletTransaction transaction = new VirtualWalletTransaction();
		transaction.setAmount(amount);
		transaction.setWalletId(fromWalletId);
		transaction.setFromWalletId(fromWalletId);
		transaction.setToWalletId(toWalletId);
		transaction.setStatus(TransactionStatus.TRANSFER);
		result=transactionMapper.saveTransaction(transaction);

			//修改订单状态
		result=ordersMapper.updateOrderState(orderId);

		return result;
	}
}
