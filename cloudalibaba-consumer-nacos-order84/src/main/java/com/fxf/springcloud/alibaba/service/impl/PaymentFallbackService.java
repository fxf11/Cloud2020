package com.fxf.springcloud.alibaba.service.impl;

import com.fxf.springcloud.alibaba.service.PaymentService;
import com.fxf.springcloud.entites.CommonResult;
import com.fxf.springcloud.entites.Payment;
import org.springframework.stereotype.Component;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/22 14:36
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));

    }
}
