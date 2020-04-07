package com.czz.springcloud.controller;

import com.czz.springcloud.entities.CommonResult;
import com.czz.springcloud.entities.Payment;
import com.czz.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalance loadBalance;

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

    @GetMapping(value = "/consume/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity (PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if (entity.getStatusCode ().is2xxSuccessful ()) {
            return entity.getBody ();
        }
        return new CommonResult<Payment>(444,"操作失败");

    }

    @GetMapping(value = "/consume/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances ("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size ()<=0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalance.instance (instances);
        URI uri = serviceInstance.getUri ();
        return restTemplate.getForObject (uri+"/payment/lb",String.class);

    }
}


