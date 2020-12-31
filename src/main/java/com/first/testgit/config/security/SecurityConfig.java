package com.first.testgit.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author:jiaxingxu
 * spring security 安全验证
 **/
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *用auth设置用户名密码
     * @date 2020/12/30 16:07
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123");



        //放入内存中 设置用户名密码和角色
        auth.inMemoryAuthentication().withUser("pb").password(encode).roles("npy");
    }

    @Bean
    PasswordEncoder  getPassWord(){
        //BCryptPasswordEncoder 是PasswordEncoder 的实现类
       return  new BCryptPasswordEncoder();
    }

}
