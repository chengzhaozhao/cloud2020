package com.czz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: create by 我心所向
 * @version: v1.0
 * @description: PaymentApplication
 * @date: 2020/3/31
 */

@SpringBootApplication
@EnableEurekaClient
public class PaymentApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run (PaymentApplication8002.class,args);
    }
}


