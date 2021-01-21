package com.mxd.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class TestController {

    @GetMapping("/")
    public String index() {
        return "/static/index.html";
    }

    @ResponseBody
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
