package com.example.demo.service.impl;

import com.example.demo.entity.UserMess;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    UserMapper userMapper;
    @Override
    public int Register(UserMess userMess) {
        int i = userMapper.register(userMess);
        return i;
    }
}
