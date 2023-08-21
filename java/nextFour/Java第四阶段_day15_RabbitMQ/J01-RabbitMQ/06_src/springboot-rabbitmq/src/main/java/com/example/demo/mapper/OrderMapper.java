package com.example.demo.mapper;

import com.example.demo.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单mapper
 * @author :master
 * @date :20200612
 */
@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}