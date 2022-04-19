package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserMess;

//这个接口是自己建的，很nb，里边啥也没有，但是可以通过这个接口调用mybatis-plus中自带的单表操作的实现方法
public interface UserMessMapper extends BaseMapper<UserMess> {

}
