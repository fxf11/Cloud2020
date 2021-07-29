package com.fxf.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/2 13:37
 */
@Configuration
public class GateWayConfig {

    /**
     * 配置一个id为path_route_fxfd的路由规则
     * 当访问地址http://localhost:9527/guonei/guonei时会自动转发到http://news.baidu.com/guonei
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_fxf",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
