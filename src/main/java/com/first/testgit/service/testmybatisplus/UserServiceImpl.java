package com.first.testgit.service.testmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.first.testgit.entity.Student;
import com.first.testgit.entity.User;
import com.first.testgit.mapper.UserMapper;
import com.first.testgit.service.testmybatisplus.base.BaseServiceImpl;
import com.first.testgit.service.testmybatisplus.teststudent.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author:jiaxingxu
 *
 *  测试的service
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements  TestUserService{

   // 构造器注入
    private final  UserMapper userMapper;

    private  final StudentService studentService;


    public UserServiceImpl(UserMapper userMapper, StudentService studentService) {
        this.userMapper = userMapper;
        this.studentService = studentService;
    }

    @Override
    public User save() {

        User one = this.getOne(new QueryWrapper<User>().eq("username", "sss"));
        return  one;
    }

    @Override
    public  User getUser(){

        LambdaQueryWrapper<User> sss = new LambdaQueryWrapper<User>().eq(User::getUsername, "sss");
        User user = userMapper.selectOne(sss);
        return  user;
    }


  @Override
    public  Student getStudent(){
        Student sss = studentService.getOne(Wrappers.<Student>lambdaQuery().eq(Student::gets_id, "01"));
        return  sss;
    }


}
