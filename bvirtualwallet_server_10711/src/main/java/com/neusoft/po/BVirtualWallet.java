package com.neusoft.po;

import java.math.BigDecimal;

public class BVirtualWallet {

    private Integer walletId;
    private BigDecimal balance=BigDecimal.ZERO;
    private Integer businessId;
    public Integer getWalletId() {
        return walletId;
    }
    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public Integer getBusinessId() {
        return businessId;
    }
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }


    //充值（入账）
    public void credit(BigDecimal amount) throws InvalidAmountException {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException("输入的金额无效");
        }
        this.balance=this.balance.add(amount);
    }

    public BigDecimal balance() {
        return this.balance;//获取余额
    }


}
