package com.neusoft.mapper;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.neusoft.po.BVirtualWallet;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.nio.charset.CodingErrorAction;

@Mapper
public interface BVirtualWalletMapper {

    @Update("update bvirtualwallet set balance=#{balance} where walletId= #{walletId}")
    public int updateBalance(Integer walletId, BigDecimal balance);

    @Select("select * from bvirtualwallet where walletId=#{walletId}")
    public BVirtualWallet getVirtualWallet(Integer walletId);


    @Select("select * from bvirtualwallet where businessId=#{businessId}")
    public BVirtualWallet getVirtualWalletByBusinessId(Integer businessId);

}
