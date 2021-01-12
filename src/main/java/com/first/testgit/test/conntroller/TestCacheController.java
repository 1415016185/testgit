package com.first.testgit.test.conntroller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:jiaxingxu
 **/
@RestController
@RequestMapping("/cache")
public class TestCacheController {

    @RequestMapping("/testCacheable")
    public String  testCacheable(@RequestParam("id") Integer id){
          return  "我是"+id;
    }


}
