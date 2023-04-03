package com.neusoft.controller;

import java.math.BigDecimal;

import com.neusoft.po.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.po.VirtualWallet;
import com.neusoft.po.VirtualWalletTransaction;
import com.neusoft.service.VirtualWalletService;
@RefreshScope //开启动态刷新
@RestController
@RequestMapping("/VirtualWallet")
public class VirtualWalletController {
	@Autowired
	private VirtualWalletService virtualWalletService;

	//根据用户编号查询虚拟钱包
	@GetMapping("/UserId")
	public CommonResult<VirtualWallet> getVirtualWalletByUserId(VirtualWallet virtualWallet){
		//return  virtualWalletService.getVirtualWalletByUserId(virtualWallet.getUserId());
		return new CommonResult(200,"success",virtualWalletService.getVirtualWalletByUserId(virtualWallet.getUserId()));
	}
	
	// 查询余额
	@GetMapping("/WalletId")
	public CommonResult<BigDecimal> getBalance(VirtualWallet virtualWallet)  {
		//BigDecimal balance=virtualWalletService.getBalance(virtualWallet.getWalletId());
		return new CommonResult(200,"success",virtualWalletService.getBalance(virtualWallet.getWalletId()));


	} 
	
	 // 出账（提现）
	@PostMapping("/FromWalletId")
	public CommonResult<Integer> debit(VirtualWallet virtualWallet, BigDecimal amount) {
		int result=virtualWalletService.debit(virtualWallet.getWalletId(), amount);
		return new CommonResult(200,"success",result);
	}
	
	// 入账（充值）
	@PostMapping("/ToWalletId")
	public CommonResult<Integer> credit(VirtualWallet virtualWallet, BigDecimal amount) {
		int result=virtualWalletService.credit(virtualWallet.getWalletId(), amount);
		return new CommonResult(200,"success",result);
	} 
	
	//转账
	@PostMapping("/WalletId")
	public CommonResult<Integer> transfer(VirtualWalletTransaction transaction, BigDecimal amount,Integer orderId) {
		int result=virtualWalletService.transfer(transaction.getFromWalletId(), transaction.getToWalletId(), amount, orderId);
		return new CommonResult(200,"success",result);
}

}
