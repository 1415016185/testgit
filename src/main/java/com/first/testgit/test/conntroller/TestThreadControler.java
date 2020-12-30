package com.first.testgit.test.conntroller;


import com.first.testgit.service.RedisService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;


/**
 * @author:jiaxingxu
 **/
@RestController
@RequestMapping("/test")
public class TestThreadControler {


    @Autowired
    private RedisService redisService;

    /**
     *测试线程
     * @date 2020/12/30 9:53
     * @param   @param:[pageable]
     * @return void
     */
    @PostMapping("/thread")
    @Async
    void  testThread(Pageable pageable){
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(Thread.currentThread().getName());
    }


    /**
     * 前端传参page 和 size get请求
     * 测试pageable 分页
     * @date 2020/12/29 14:27
     */
    @GetMapping("/pageable")
    @Async
    void  testPageable(String key,Pageable pageable){
        System.out.println(key);
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(Thread.currentThread().getName());
    }

    /**
     *查询Redis缓存
     * @date 2020/12/30 9:53
     * @param   @param:[key, pageable]
     * @return org.springframework.http.ResponseEntity
     */
    @GetMapping(value = "/redis")
    public ResponseEntity getRedis(String key, Pageable pageable){
        return new ResponseEntity(redisService.findByKey(key,pageable), HttpStatus.OK);
    }




}
