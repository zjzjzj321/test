package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.common.Result;
import com.example.demo.mapper.Dao;
import com.example.demo.entity.UserMess;
import com.example.demo.mapper.UserMessMapper;
import com.example.demo.service.LoginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    UserMessMapper um;
    @Resource
    Dao dao;
    @Resource
    LoginService loginService;
    @RequestMapping("/login")
    public Result<?> save(@RequestBody UserMess userMess){
        UserMess res =
                um.selectOne(Wrappers.<UserMess>lambdaQuery()
                        .eq(UserMess::getUsername, userMess.getUsername())
                        .eq(UserMess::getPassword,userMess.getPassword()));
        if(res == null){
            return Result.error("-1","用户名或密码错误");
        }
        return Result.success();
    }
    @RequestMapping("/register")
    public Result<?> register(@RequestBody UserMess userMess){
        int i = 0;
        UserMess res =
                um.selectOne(Wrappers.<UserMess>lambdaQuery()
                        .eq(UserMess::getUsername, userMess.getUsername())
                        .eq(UserMess::getPassword,userMess.getPassword()));
        if(res == null){
            i = loginService.Register(userMess);
        }
        if (i > 0){
            return Result.success();
        }else{
            return Result.error("20","注册失败，请联系管理员");
        }
    }


    public  String aa(){

        return "";
    }
}
