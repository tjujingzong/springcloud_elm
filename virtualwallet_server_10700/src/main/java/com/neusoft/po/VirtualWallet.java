package com.neusoft.po;

import java.math.BigDecimal;


public class VirtualWallet {
	private Integer walletId;
    private BigDecimal balance;
    private String userId;
    
    
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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
	

	public VirtualWallet(Integer preAllocatedId) {
		this.walletId = preAllocatedId;//预分配的Id
	}
    
        
    //提现（出账）
    public void debit(BigDecimal amount) throws InsufficientBalanceException {
		if (this.balance.compareTo(amount) < 0) {
			throw new InsufficientBalanceException("余额不足");
		}
		this.balance=balance.subtract(amount);
	}
    
    //充值（入账）
    public void credit(BigDecimal amount) throws InvalidAmountException{
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new InvalidAmountException("输入的金额无效");
		}
		this.balance=this.balance.add(amount);
	}
    
    public BigDecimal balance() {return this.balance;//获取余额
	}
    
}
