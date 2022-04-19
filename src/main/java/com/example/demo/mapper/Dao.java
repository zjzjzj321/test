package com.example.demo.mapper;

import com.example.demo.entity.UserMess;

import java.util.List;

public interface Dao {

    public int inserttousermess(UserMess userMess);
    public List<UserMess> selall();
    public List<String> repeated(String username);
}
