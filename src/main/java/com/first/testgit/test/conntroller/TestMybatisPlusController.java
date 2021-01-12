package com.first.testgit.test.conntroller;

import com.first.testgit.entity.User;
import com.first.testgit.service.testmybatisplus.TestUserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:jiaxingxu
 **/

@RestController
@RequestMapping("/TestMybatis")
public class TestMybatisPlusController {

    private final TestUserService testUserService;

    public TestMybatisPlusController(TestUserService testUserService) {
        this.testUserService = testUserService;
    }

    @PostMapping("/test")
    public User testCacheable(){
        return   testUserService.save();
    }



}
