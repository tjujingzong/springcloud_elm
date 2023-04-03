package com.neusoft.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class VirtualWalletTransaction {
	private Integer transactionId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp createTime;
	private BigDecimal amount;
	private String status;
	private Integer fromWalletId;
	private Integer toWalletId;
	private Integer walletId;
	
	
	
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getFromWalletId() {
		return fromWalletId;
	}
	public void setFromWalletId(Integer fromWalletId) {
		this.fromWalletId = fromWalletId;
	}
	public Integer getToWalletId() {
		return toWalletId;
	}
	public void setToWalletId(Integer toWalletId) {
		this.toWalletId = toWalletId;
	}
	public Integer getWalletId() {
		return walletId;
	}
	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}
	
	

}
