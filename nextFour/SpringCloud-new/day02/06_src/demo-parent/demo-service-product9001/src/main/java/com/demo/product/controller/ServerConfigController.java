package com.demo.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ServerConfigController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("query")
    public String findServerPort(){
        return serverPort;
    }

}