package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.mapper.Dao;
import com.example.demo.entity.UserMess;
import com.example.demo.mapper.UserMessMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class UserController {
    @Resource
    UserMessMapper um;
    @Resource
    Dao dao;

//    @RequestMapping("/selall")
//    public List<UserMess> selall( @RequestParam(defaultValue = "") String search,
//                                  @RequestParam(defaultValue = "1") Integer pageNum,
//                                  @RequestParam(defaultValue = "5") Integer pageSize ){
//        List<UserMess> list = dao.selall();
//        for (int i =- 0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
//        return list;
//    }


    @RequestMapping("/user")
    public Result<?> save(@RequestBody UserMess userMess){
        //这句话的作用是将前台传来的数据，放到实体类里边
        //um.insert(userMess);
        //System.out.println(userMess);
        int i = dao.inserttousermess(userMess);
        return Result.success();
    }
    @RequestMapping("/selall")
    public Result<?> selall(){
        //这句话的作用是将前台传来的数据，放到实体类里边
        //um.insert(userMess);
        //System.out.println(userMess);
        return Result.success(dao.selall());
    }

    @RequestMapping("/getall")
    public Result<?> getAll(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize)
            {
        LambdaQueryWrapper<UserMess> warper = Wrappers.<UserMess>lambdaQuery().like(UserMess::getUsername, search);
        if (StringUtils.isBlank(search)){
            //StringUtils.isBlank(search)  这个东西 ，如果里边的值不为空就是true，为空就false
             //System.out.println("condition不为空");
            warper.like(UserMess::getUsername,search);
        }else {
            warper.like(UserMess::getUsername,"");
        }
        Page<UserMess> userMessPage = um.selectPage(new Page<>(pageNum, pageSize),warper);
        return Result.success(userMessPage);
    }

    @RequestMapping("/update")
    public Result<?> update(@RequestBody UserMess userMess){
        um.updateById(userMess);
        return Result.success();
    }

    @RequestMapping("/delete")
    public Result<?> update( Long id){
        um.deleteById(id);
        return Result.success();
    }

    //查看用户名是否重复
    @GetMapping("/repeated")
    public Result<?> repeated(String username){
        return Result.success(dao.repeated(username));
    }
}
