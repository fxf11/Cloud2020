package com.fxf.springcloud.alibaba.service;

import com.fxf.springcloud.alibaba.service.impl.PaymentFallbackService;
import com.fxf.springcloud.entites.CommonResult;
import com.fxf.springcloud.entites.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/22 14:33
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)//调用中关闭9003服务提供者
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
