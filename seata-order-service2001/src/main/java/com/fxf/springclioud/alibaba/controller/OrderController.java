package com.fxf.springclioud.alibaba.controller;

import com.fxf.springclioud.alibaba.domain.CommonResult;
import com.fxf.springclioud.alibaba.domain.Order;
import com.fxf.springclioud.alibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/23 15:28
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        System.out.println(order.getMoney().toString());
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
