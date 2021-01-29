package com.first.testgit.config.security;

import com.first.testgit.service.impl.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;*/

import javax.sql.DataSource;

/**
 * @author:jiaxingxu
 **/
//@Configuration  extends WebSecurityConfigurerAdapter
public class SecurityConfigTest {
/*
    @Autowired
    private MyUserDetailsServiceImpl userDetailsService;
    @Autowired
    private DataSource dataSource;

    //配置对象
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    *//*
     *   *用auth设置用户名密码
     * @date 2020/12/30 16:07

     * *//*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPassWord());

    }


    @Bean
    PasswordEncoder getPassWord() {
        //BCryptPasswordEncoder 是PasswordEncoder 的实现类
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests();
        //退出
        http.logout().logoutUrl("/logout").
                logoutSuccessUrl("/test/hello").permitAll();

        //配置没有权限访问跳转自定义页面
        http.exceptionHandling().accessDeniedPage("/demo/demo.html");
        http.formLogin()
                //自定义自己编写的登录页面 登录页所有人都能访问
                .loginPage("/demo/testlogin.html").permitAll()
                //登录页面设置
                .loginProcessingUrl("/user/login")
                //登录访问路径
                //.successForwardUrl("/test/hello").permitAll()
                .defaultSuccessUrl("/test/hello", true).permitAll()
                .and().authorizeRequests()
                //这些默认不用考虑 就能直接访问

                .antMatchers("/"
                        , "/test/redis"
                        , "/cache/testCacheable"
                        , "/TestMybatis/test"
                        , "/test/test").permitAll()
                //当前登录用户，只有具有admins权限才可以访问这个路径  这个只有一个
                //   .antMatchers("/test/hello").hasAuthority("admins")
                //2 hasAnyAuthority方法  可以有多个
                .antMatchers("/test/hello").hasAnyAuthority("admins")

                .and().rememberMe().tokenRepository(persistentTokenRepository())
                //设置有效时长，单位秒
                .tokenValiditySeconds(60)
                //查询数据库
                .userDetailsService(userDetailsService);


        super.configure(http);
    }*/
}
