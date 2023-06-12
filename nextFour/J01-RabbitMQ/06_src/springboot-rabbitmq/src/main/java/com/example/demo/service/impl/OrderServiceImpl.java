package com.example.demo.service.impl;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public int add(Order order) {
        int i = 0;
        if (StringUtils.isEmpty(orderMapper.selectByPrimaryKey(order.getOrderId()))) {
            i = orderMapper.insertSelective(order);
        }
        return i;
    }
}
