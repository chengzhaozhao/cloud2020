package com.czz.springcloud.service;

import com.czz.springcloud.dao.PaymentDao;
import com.czz.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: create by 我心所向
 * @version: v1.0
 * @description: ${PACAGE_NAME}
 * @date: 2020/3/31
 */
@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create (payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById (id);
    }
}


