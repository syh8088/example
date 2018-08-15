package com.example.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloRestController {

    @RequestMapping("/write")
    public String write() {
        return "write";
    }

    @RequestMapping("/appNotice")
    public String appNotice() {
        return "appNotice";
    }
}
