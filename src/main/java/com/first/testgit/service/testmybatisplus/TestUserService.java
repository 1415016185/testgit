package com.first.testgit.service.testmybatisplus;

import com.first.testgit.entity.User;

/**
 * @author:jiaxingxu
 **/
public interface TestUserService  extends   BaseService<User>{
    //测试
    User  save();
}
