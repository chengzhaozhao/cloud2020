package com.czz.springcloud.controller;

import com.czz.springcloud.entities.CommonResult;
import com.czz.springcloud.entities.Payment;
import com.czz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: create by 我心所向
 * @version: v1.0
 * @description: ${PACAGE_NAME}
 * @date: 2020/3/31
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create (payment);
        log.info ("*********插入结果："+result);
        if (result>0) {
            return new CommonResult (200,"插入数据库成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentByID(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById (id);
        log.info ("*********查询结果："+result);
        if (result!=null) {
            return new CommonResult (200,"查询成功",result);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }
}


