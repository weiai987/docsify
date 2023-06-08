package com.demo.product.service.impl;

import com.demo.common.pojo.Products;
import com.demo.product.mapper.ProductMapper;
import com.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    /**
     * 根据商品ID查询商品对象
     */
    @Override
    public Products findById(Integer productId) {
        return productMapper.selectById(productId);
    }
}