package com.neusoft.controller;

import java.util.List;

import com.neusoft.po.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.po.VirtualWalletTransaction;
import com.neusoft.service.VirtualWalletTransactionService;
@RefreshScope //开启动态刷新
@RestController
@RequestMapping("/VirtualWalletTransaction")
public class VirtualWalletTransactionController {
	@Autowired
	private VirtualWalletTransactionService transactionService;
	
	@GetMapping("/WalletId")
    public CommonResult<List> listTransactionBywalletId(VirtualWalletTransaction transaction){
		List<VirtualWalletTransaction> list=transactionService.listTransactionBywalletId(transaction.getWalletId());
	    return new CommonResult(200,"success",list);
    }

}
