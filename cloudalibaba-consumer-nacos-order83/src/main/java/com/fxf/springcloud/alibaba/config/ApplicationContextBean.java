package com.fxf.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/10 21:56
 */
@Configuration
public class ApplicationContextBean {
    @Bean
    @LoadBalanced   //配置负载均衡策略
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
