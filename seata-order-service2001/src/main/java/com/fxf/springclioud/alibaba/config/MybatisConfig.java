package com.fxf.springclioud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/23 15:47
 */
@Configuration
@MapperScan({"com.fxf.springclioud.alibaba.dao"})
public class MybatisConfig {
}
