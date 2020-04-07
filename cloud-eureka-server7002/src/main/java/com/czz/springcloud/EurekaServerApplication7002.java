package com.czz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: create by 我心所向
 * @version: v1.0
 * @description: ${PACAGE_NAME}
 * @date: 2020/3/31
 */
@RefreshScope
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication7002 {
    public static void main(String[] args) {
        SpringApplication.run (EurekaServerApplication7002.class,args);
    }
}


