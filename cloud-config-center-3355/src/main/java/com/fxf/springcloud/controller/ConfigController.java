package com.fxf.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/3 21:28
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${config}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
