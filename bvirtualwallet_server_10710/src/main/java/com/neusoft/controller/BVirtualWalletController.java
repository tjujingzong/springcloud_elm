package com.neusoft.controller;

import com.neusoft.po.BVirtualWallet;
import com.neusoft.po.CommonResult;
import com.neusoft.service.BVirtualWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope //开启动态刷新
@RestController
@RequestMapping("/BVirtualWallet")
public class BVirtualWalletController {
    @Autowired
    private BVirtualWalletService bVirtualWalletService;

    @GetMapping("/BusinessId")
    public CommonResult<BVirtualWallet> getVirtualWalletByBusinessId(BVirtualWallet bVirtualWallet){
        return new CommonResult(200,"success",bVirtualWalletService.getVirtualWalletByBusinessId(bVirtualWallet.getBusinessId()));
    }

}
