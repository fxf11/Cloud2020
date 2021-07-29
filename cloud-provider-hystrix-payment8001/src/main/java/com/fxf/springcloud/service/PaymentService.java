package com.fxf.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/4/24 17:32
 */

@Service
public class PaymentService {

    //服务降级
    public String PaymentInfo_OK(Integer id){
        //Thread.currentThread().getName()获取当前处理的线程池名称
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_ok,id:："+id+"\t"+"O(∩_∩)O哈哈";
    }
//一旦服务方法调用失败并抛出异常后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的PaymentInfo_TimeOutHandle方法
    @HystrixCommand(fallbackMethod = "PaymentInfo_TimeOutHandle",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String PaymentInfo_TimeOut(Integer id){
        //Thread.currentThread().getName()获取当前处理的线程池名称
        try {
//            System.out.println(123+"s");
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("a123af");
        return "线程池："+Thread.currentThread().getName()+"PaymentInfo_TimeOut,id:："+id+"\t"+"O(∩_∩)O不行，耗时3秒";
    }
    public String PaymentInfo_TimeOutHandle(Integer id){
        //Thread.currentThread().getName()获取当前处理的线程池名称
        return "线程池："+Thread.currentThread().getName()+"PaymentInfo_TimeOutHandle,id:："+id+"\t"+"兜底方案";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw new RuntimeException("******id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"paymentCircuitBreaker,id:："+id;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后再试，id："+id;
    }

}
