package com.neusoft.po;

/**
 * @Author：ljz
 * @Date：2022/11/21 15:24
 * @Description:
 */
public class Credit {
    private Integer creditId;

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    private Integer deleted;//0:未删除 1:已删除

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;
    private Integer channelType;
    private Integer num;
    private String createTime;
    private String expiredTime;

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }


    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Integer getCreditId() {
        return creditId;
    }


    public Integer getChannelType() {
        return channelType;
    }

    public Integer getNum() {
        return num;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getExpiredTime() {
        return expiredTime;
    }


}
