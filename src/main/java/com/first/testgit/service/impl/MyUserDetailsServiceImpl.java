package com.first.testgit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.first.testgit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author:jiaxingxu
 *
 * 这边可以查询数据库 用户名密码
 **/
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //查询
        QueryWrapper<com.first.testgit.entity.User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username",name);
         //查询到一条记录
        com.first.testgit.entity.User user = userMapper.selectOne(userQueryWrapper);
        if(null==user){
            throw  new  UsernameNotFoundException("用户名不存在");
        }
        //加上权限
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        //权限不能为空
        return new User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()),auths);
    }
}
