package com.fxf.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StroageDao {
    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
