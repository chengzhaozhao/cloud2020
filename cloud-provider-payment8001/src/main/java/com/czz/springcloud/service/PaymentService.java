package com.czz.springcloud.service;

import com.czz.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author: create by 我心所向
 * @version: v1.0
 * @description: ${PACAGE_NAME}
 * @date: 2020/3/31
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}


