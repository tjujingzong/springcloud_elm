package com.neusoft.po;

import com.neusoft.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：ljz
 * @Date：2022/11/24 15:16
 * @Description:
 */
public class CreditList {
    private List<Credit> list;
    private List<Credit> expiredList = new ArrayList<>();

    public List<Credit> getDeletedList() {
        return deletedList;
    }

    private List<Credit> deletedList = new ArrayList<>();
    private Credit updatedCredit;


    public CreditList(List<Credit> list) {
        this.list = list;
    }

    public int getTotalNum() {
        Integer totalCredit = 0;
        //将list中所有expierdTime小于当前时间的积分删除,剩余积分求和
        for (Credit credit : list) {
            if (CommonUtil.compareDate(credit.getExpiredTime(), CommonUtil.getCurrentDate1()) == 1) {
                totalCredit += credit.getNum();
            } else {
                expiredList.add(credit);
            }
        }
        return totalCredit;
    }

    public List<Credit> getExpiredList() {
        return expiredList;
    }

    public Credit getUpdatedCredit(Integer left) {
        //将list中所有credit按expiredTime升序排序
        list.sort((o1, o2) -> {
            if (CommonUtil.compareDate(o1.getExpiredTime(), o2.getExpiredTime()) == 1)
                return 1;
            else if (CommonUtil.compareDate(o1.getExpiredTime(), o2.getExpiredTime()) == -1)
                return -1;
            else
                return 0;
        });
        //遍历list,将积分从最早过期的开始扣除,直到left<=0
        for (Credit credit1 : list) {
            if (left == 0)
                break;
            if (CommonUtil.compareDate(credit1.getExpiredTime(), CommonUtil.getCurrentDate1()) == 1) {
                if (credit1.getNum() >= left) {
                    credit1.setNum(credit1.getNum() - left);
                    left = 0;
                    updatedCredit = credit1;
                } else {
                    left -= credit1.getNum();
                    deletedList.add(credit1);
                }
            }
        }
        return updatedCredit;
    }
}
