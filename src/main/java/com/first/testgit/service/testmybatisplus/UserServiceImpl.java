package com.first.testgit.service.testmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.first.testgit.entity.User;
import com.first.testgit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:jiaxingxu
 *
 *  测试的service
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User>  implements  TestUserService{

   // 构造器注入
    private final  UserMapper userMapper;


    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User save() {

        User one = this.getOne(new QueryWrapper<User>().eq("username", "sss"));
        return  one;
    }
}
