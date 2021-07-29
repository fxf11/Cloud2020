package com.fxf.springcloud.controller;

import com.fxf.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/4 23:47
 */
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String send(){
        return messageProvider.send();
    }
}
