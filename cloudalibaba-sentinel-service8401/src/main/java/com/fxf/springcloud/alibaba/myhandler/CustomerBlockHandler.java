package com.fxf.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fxf.springcloud.entites.CommonResult;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/21 22:35
 */
public class CustomerBlockHandler
{
    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息......CustomerBlockHandler");
    }
}
