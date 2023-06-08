package com.demo.page.controller;

import com.demo.common.pojo.Products;
import com.demo.page.feign.ProductFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/page")
public class PageController {
    @Autowired
    private ProductFeign productFeign;
    @RequestMapping("/getData/{id}")
    public Products findDataById(@PathVariable Integer id) {
        return productFeign.query(id);
    }
    @RequestMapping("/getPort")
    public String getProductServerPort() {
        return productFeign.findServerPort();
    }

}