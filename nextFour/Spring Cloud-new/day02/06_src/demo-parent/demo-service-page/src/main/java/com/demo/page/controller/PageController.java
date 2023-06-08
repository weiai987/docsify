package com.demo.page.controller;

import com.demo.common.pojo.Products;
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

    @RequestMapping("/getPort")
    public String getProductServerPort(){
        String url = "http://demo-service-product/server/query";
        return restTemplate.getForObject(url,String.class);
    }


    /**
     * 提供者模拟处理超时，调用方法添加Hystrix控制
     */
    // 使用@HystrixCommand注解进行熔断控制
    @HystrixCommand(
            // 线程池标识，要保持唯一，不唯一的话就共用了
            threadPoolKey = "getProductServerPort2",
            // 线程池细节属性配置
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize",value = "1"), // 线程数
                    @HystrixProperty(name="maxQueueSize",value="20") // 等待队列长度
            },
            // commandProperties熔断的一些细节属性配置
            commandProperties = {
                    // 每一个属性都是一个HystrixProperty
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
            }
    )
    @RequestMapping("/getPort2")
    public String getProductServerPort2(){
        String url = "http://demo-service-product/server/query";
        return restTemplate.getForObject(url,String.class);
    }

    @HystrixCommand(
            // 线程池标识，要保持唯一，不唯一的话就共用了
            threadPoolKey = "getProductServerPort3TimeoutFallback",
            // 线程池细节属性配置
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"), // 线程数
                    @HystrixProperty(name = "maxQueueSize", value = "20") // 等待队列长度
            },
            // commandProperties熔断的一些细节属性配置
            commandProperties = {
                    // 每一个属性都是一个HystrixProperty
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    // hystrix高级配置，定制工作过程细节
                    // 统计时间窗口定义
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "8000"),
                    // 统计时间窗口内的最小请求数
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
                    // 统计时间窗口内的错误数量百分比阈值
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    // 自我修复时的活动窗口长度
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000")
            },
            fallbackMethod = "myFallBack"  // 回退方法
    )
    @RequestMapping("/getPort3")
    public String getProductServerPort3() {
        String url = "http://demo-service-product/server/query";
        return restTemplate.getForObject(url, String.class);
    }


    /**
     * 定义回退方法，返回预设默认值
     * 注意：该方法形参和返回值与原始方法保持一致
     */
    public String myFallBack() {
        return "-1"; // 兜底数据
    }
}