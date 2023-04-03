package com.neusoft.controller;

/**
 * @Author：ljz
 * @Date：2022/11/21 15:54
 * @Description:
 */

import com.neusoft.po.CommonResult;
import com.neusoft.po.Credit;
import com.neusoft.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/Credit")
public class CreditController {
    @Autowired
    private CreditService creditService;

    @GetMapping("/totalNum")
    public CommonResult<Integer> getTotalCreditByUserId(Credit credit) throws Exception {
        return new CommonResult<Integer>(200, "success", creditService.getTotalCreditByUserId(credit.getUserId()));
    }

    @GetMapping("/availableCredit")
    public CommonResult<List<Credit>> getAvailableCreditByUserId(Credit credit) throws Exception {
        return new CommonResult<List<Credit>>(200, "success", creditService.getAvailableCreditByUserId(credit.getUserId()));
    }

    @GetMapping("/userId")
    public CommonResult<List<Credit>> getCreditByUserId(Credit credit) throws Exception {
        return new CommonResult<List<Credit>>(200, "success", creditService.getCreditByUserId(credit.getUserId()));
    }

    @GetMapping("/channelType")
    public CommonResult<List<Credit>> getCreditByUserIdAndChannelType(Credit credit) throws Exception {
        return new CommonResult<List<Credit>>(200, "success", creditService.getCreditByUserIdAndChannelType(credit.getUserId(), credit.getChannelType()));
    }

    @PostMapping("/userId")
    public CommonResult<Integer> insertCredit(Credit credit) throws Exception {
        return new CommonResult<Integer>(200, "success", creditService.insertCredit(credit));
    }
}
