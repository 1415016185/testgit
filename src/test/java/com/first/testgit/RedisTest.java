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
import org.springframework.data.redis.core.ValueOperations;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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

    @Test
    void  testNoxee(){
        //设置初始值
        LinkedHashMap<Object, Object> objectObjectHashMap = new LinkedHashMap<>(15);
        for (int i = 0; i < 10; i++) {
            objectObjectHashMap.put("test"+i,i);
        }
        for (Map.Entry<Object, Object> objectObjectEntry : objectObjectHashMap.entrySet()) {
            System.out.println(objectObjectEntry.getKey());
            System.out.println(objectObjectEntry.getValue());

        }
        redisTemplate.opsForValue().multiSet(objectObjectHashMap);


    }
}
