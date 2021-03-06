package com.fxf.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/23 15:58
 */
public interface AccountService {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
