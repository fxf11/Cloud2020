package com.fxf.springcloud.controller;

import com.fxf.springcloud.entites.CommonResult;
import com.fxf.springcloud.entites.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/comsumer/consul/zk")
    public String paymentInfo(){
        String forObject = restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
        return forObject;
    }

}
