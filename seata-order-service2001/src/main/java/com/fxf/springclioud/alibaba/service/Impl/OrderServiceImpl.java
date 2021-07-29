package com.fxf.springclioud.alibaba.service.Impl;

import com.fxf.springclioud.alibaba.dao.OrderDao;
import com.fxf.springclioud.alibaba.domain.Order;
import com.fxf.springclioud.alibaba.service.AccountService;
import com.fxf.springclioud.alibaba.service.OrderService;
import com.fxf.springclioud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/23 15:25
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------->下单开始");
        //本应用创建订单
        orderDao.create(order);
        log.info("------->order-service中扣减库存开始");
//        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->order-service中扣减库存结束");

        log.info("------->order-service中扣减余额开始");
//        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->order-service中扣减余额结束");

        log.info("------->修改订单状态开始");
//        orderDao.updata(order.getUserId(),0);
        log.info("------->修改订单状态结束");
        log.info("------->下单结束了");

    }
}
