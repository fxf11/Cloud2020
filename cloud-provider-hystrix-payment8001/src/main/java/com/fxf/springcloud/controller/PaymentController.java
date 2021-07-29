package com.fxf.springcloud.controller;

import com.fxf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/4/24 17:42
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String  serverPort;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.PaymentInfo_OK(id);
        log.info("result:*********"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String PaymentInfo_TimeOut(@PathVariable("id") Integer id){
        System.out.println("123");
        String result = paymentService.PaymentInfo_TimeOut(id);
        log.info("result:*********"+result);
        return result;
    }
    //==========服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreajer(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*****result:"+result);
        return result;
    }
}
