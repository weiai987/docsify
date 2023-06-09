package com.demo.page.controller;

import com.demo.common.pojo.Products;
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
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping("/getData/{id}")
    public Products findDataById(@PathVariable Integer id){
        //1.获得Eureka中注册的demo-service-product实例集合
        List<ServiceInstance> instances = discoveryClient.getInstances("demo-service-product");
        //2.获得实例集合中的第一个
        ServiceInstance instance = instances.get(0);
        //3.根据实例信息拼接IP地址
        String host = instance.getHost();
        int port = instance.getPort();
        String url = "http://"+host+":"+port+"/product/query/"+id;
        //4.调用
        Products products = restTemplate.getForObject(url, Products.class);
        System.out.println("从demo-service-product获得product对象:"+products);
        return products;
    }
}