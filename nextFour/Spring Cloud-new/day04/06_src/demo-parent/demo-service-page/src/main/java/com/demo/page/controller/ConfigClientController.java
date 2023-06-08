package com.demo.page.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope  //手动刷新
public class ConfigClientController {

    @Value("${mysql.user}")
    private String mysqlUser;

    @Value("${person.name}")
    private String personName;

    @RequestMapping("/remote")
    public String findRemoteConfig() {
        return mysqlUser + "  " + personName;
    }

}