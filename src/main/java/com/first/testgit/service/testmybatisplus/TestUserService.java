package com.first.testgit.service.testmybatisplus;

import com.first.testgit.entity.Student;
import com.first.testgit.entity.User;
import com.first.testgit.service.testmybatisplus.base.BaseService;

/**
 * @author:jiaxingxu
 **/
public interface TestUserService  extends BaseService<User> {
    //测试
    User  save();

    User getUser();

    Student getStudent();
}
