package com.demo.page.feign;

import com.demo.common.pojo.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "demo-service-product")
public interface ProductFeign {

    /**
     * 通过id获取商品信息
     * @param id
     * @return
     */
    @RequestMapping("/product/query/{id}")
    public Products query(@PathVariable Integer id);

    /**
     * 获得端口号
     * @return
     */
    @RequestMapping("/server/query")
    public String findServerPort();

}
