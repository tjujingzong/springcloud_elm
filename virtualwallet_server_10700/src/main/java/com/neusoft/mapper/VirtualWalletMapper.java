package com.neusoft.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neusoft.po.VirtualWallet;

@Mapper
public interface VirtualWalletMapper {
	@Select("select * from virtualwallet where walletId=#{walletId}")
	public VirtualWallet getVirtualWallet(Integer walletId);
	
	@Select("select balance from virtualWallet where walletId=#{walletId}")
	public BigDecimal getBalance(Integer walletId);
	
	@Update("update virtualwallet set balance=#{balance} where walletId= #{walletId}")
	public int updateBalance(@Param("walletId") Integer walletId, @Param("balance") BigDecimal balance);

	@Select("select * from virtualwallet where userId=#{userId}")
	public VirtualWallet getVirtualWalletByUserId(String userId);
	
}
