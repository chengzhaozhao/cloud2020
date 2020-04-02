package com.com.czz.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: create by 我心所向
 * @version: v1.0
 * @description: ${PACAGE_NAME}
 * @date: 2020/3/31
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getrRestTemplate(){
        return new RestTemplate ();
    }
}


