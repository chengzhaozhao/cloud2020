package com.com.czz.springcloud.controller;

import com.czz.springcloud.entities.CommonResult;
import com.czz.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: create by 我心所向
 * @version: v1.0
 * @description: OrderController
 * @date: 2020/3/31
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consume/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject (PAYMENT_URL+"/payment/create",payment,CommonResult.class);

    }

    @GetMapping(value = "/consume/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject (PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}


