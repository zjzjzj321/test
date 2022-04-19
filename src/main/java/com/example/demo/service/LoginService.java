package com.example.demo.service;

import com.example.demo.entity.UserMess;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public int Register(UserMess userMess);

}
