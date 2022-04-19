package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Tesr {

    @ResponseBody
    @RequestMapping("/tosome")
    public String toSome(){
        return "123123";
    }

}
