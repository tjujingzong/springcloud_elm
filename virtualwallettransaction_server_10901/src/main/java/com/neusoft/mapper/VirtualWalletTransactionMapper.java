package com.neusoft.mapper;

import com.neusoft.po.VirtualWalletTransaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VirtualWalletTransactionMapper {
	
	@Insert("insert into virtualwallettransaction (amount,status,fromWalletId,toWalletId,walletId) values (#{amount},#{status},#{fromWalletId},#{toWalletId},#{walletId})")
	public int saveTransaction(VirtualWalletTransaction transaction);//插入交易记录
    
	@Select("select * from virtualwallettransaction where walletId=#{walletId} order by transactionId desc")
	public List<VirtualWalletTransaction> listTransactionBywalletId(Integer walletId);//查询历史记录
	
}
