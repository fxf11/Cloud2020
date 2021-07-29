package com.fxf.springclioud.alibaba.service;

import com.fxf.springclioud.alibaba.domain.Order;
import org.springframework.stereotype.Service;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/23 15:24
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

}
