package com.fxf.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/4/25 23:13
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------------PaymentFallbackService fall paymentInfo_OK,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---------------PaymentFallbackService fall paymentInfo_TimeOut,/(ㄒoㄒ)/~~";
    }
}
