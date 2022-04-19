package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("usermess")
@Data
public class UserMess {
    //这里需要注意，如果默认叫id就不用写，但是如果数据库中的不叫id而是uid，那么就需要写在里边，
    //设置ID自增
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String username;
    private String password;
    private String nickName;
    private int age;
    private String sex;
    private String address;
}
