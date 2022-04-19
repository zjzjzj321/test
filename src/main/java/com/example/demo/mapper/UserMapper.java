package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserMess;

public interface UserMapper {

    int register(UserMess userMess);
}
