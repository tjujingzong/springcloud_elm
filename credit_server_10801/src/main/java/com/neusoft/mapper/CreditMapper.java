package com.neusoft.mapper;

import com.neusoft.po.Credit;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author：ljz
 * @Date：2022/11/21 15:36
 * @Description:
 */
@Mapper
public interface CreditMapper {
    //get total credit by userId and not deleted
    @Select("select * from credit_copy where userId=#{userId} and deleted=0")
    public List<Credit> getTotalCreditByUserId(String userId);

    //get credit by userId
    @Select("select * from credit where userId=#{userId}")
    public List<Credit> getCreditByUserId(String userId);

    //get credit by userId and channelType
    @Select("select * from credit where userId=#{userId} and channelType=#{channelType}")
    public List<Credit> getCreditByUserIdAndChannelType(String userId, int channelType);

    //insert credit
    @Insert("insert into credit(userId, num, channelType, createTime,expiredTime) values(#{userId}, #{num}, #{channelType}, #{createTime},#{expiredTime})")
    @Options(useGeneratedKeys = true, keyProperty = "creditId", keyColumn = "creditId")
    public int insertCredit(Credit credit);

    @Insert("insert into credit_copy(userId, num, channelType, createTime,expiredTime) values(#{userId}, #{num}, #{channelType}, #{createTime},#{expiredTime})")
    @Options(useGeneratedKeys = true, keyProperty = "creditId", keyColumn = "creditId")
    public int insertCreditCopy(Credit credit);

    //update credit_copy deleted=1 by creditId
    @Update("update credit_copy set deleted=1 where creditId=#{creditId}")
    public int deleteCreditCopyByCreditId(int creditId);

    //update credit_copy set num=leftnum by creditId
    @Update("update credit_copy set num=#{leftNum} where creditId=#{creditId}")
    public int updateCreditCopyByCreditId(@Param("creditId") int creditId, @Param("leftNum") int leftNum);
}
