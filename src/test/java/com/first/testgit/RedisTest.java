package com.first.testgit;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.first.testgit.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author:jiaxingxu
 **/

@SpringBootTest
public class RedisTest
{

    //有重名的     @Qualifier
    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate redisTemplate;

    /*
    *
    * 这种序列化方式  "\"{\\\"id\\\":1,\\\"username\\\":\\\"xxx\\\",\\\"password\\\":\\\"ccc\\\"}\""
    * */
    @Test
    void  redis(){
        User user = new User(1, "xxx", "ccc");
        try {
            //序列化
            String s = new ObjectMapper().writeValueAsString(user);
            redisTemplate.opsForValue().set("user",s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println( redisTemplate.opsForValue().get("user"));

    }

/*
*{\"@class\":\"com.first.testgit.entity.User\",\"id\":1,\"username\":\"xxx\",\"password\":\"ccc\"}"
* 测试没有序列话   直接传对象会报错*/
    @Test
    void  testNoxlh(){
        User user = new User(1, "xxx", "ccc");
        String s = JSONObject.toJSONString(user);
        System.out.println(s);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));

    }
}
