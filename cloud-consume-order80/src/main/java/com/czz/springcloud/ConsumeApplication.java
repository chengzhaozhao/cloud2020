package com.czz.springcloud;

import com.czz.ribbion.rule.RibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author: create by 我心所向
 * @version: v1.0
 * @description: ${PACAGE_NAME}
 * @date: 2020/3/31
 */
@SpringBootApplication
@RibbonClient(name = "CLOUD_PAYMENT_SERVICE",configuration = RibbonRule.class)
public class ConsumeApplication {
    public static void main(String[] args) {
        SpringApplication.run (ConsumeApplication.class,args);
    }
}



