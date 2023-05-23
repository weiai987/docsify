package com.blb.bookms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pages")
public class PageController {

    @RequestMapping("{page}")
    public String toPage(@PathVariable("page") String page){
        return page;
    }
}
