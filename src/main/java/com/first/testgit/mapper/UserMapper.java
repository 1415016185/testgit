package com.first.testgit.mapper;

import com.first.testgit.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}