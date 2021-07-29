package com.fxf.springclioud.alibaba.dao;

import com.fxf.springclioud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/5/23 15:10
 */
@Mapper
public interface OrderDao {

    void create(Order order);

    void updata(@Param("userId") Long userId,@Param("status") Integer status);
}
