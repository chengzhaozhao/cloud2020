package com.czz.springcloud.dao;

import com.czz.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: create by 我心所向
 * @version: v1.0
 * @description: PaymentDao
 * @date: 2020/3/31
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param ("id") Long id);
}


