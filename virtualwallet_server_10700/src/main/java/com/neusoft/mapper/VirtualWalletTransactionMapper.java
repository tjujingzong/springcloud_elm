package com.neusoft.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neusoft.po.VirtualWalletTransaction;

@Mapper
public interface VirtualWalletTransactionMapper {
	
	@Insert("insert into virtualwallettransaction (amount,status,fromWalletId,toWalletId,walletId) values (#{amount},#{status},#{fromWalletId},#{toWalletId},#{walletId})")
	public int saveTransaction(VirtualWalletTransaction transaction);//插入交易记录
    
	@Select("select * from virtualwallettransaction where walletId=#{walletId}")
	public List<VirtualWalletTransaction> listTransactionBywalletId(Integer walletId);//查询历史记录
	
}
