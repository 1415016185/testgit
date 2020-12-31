package com.first.testgit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.first.testgit.entity.User;
import org.springframework.stereotype.Repository;

/*
* 这个加上了mybatis plus
 */
@Repository
public interface UserMapper  extends BaseMapper<User> {
    int insert(User record);

    int insertSelective(User record);
}