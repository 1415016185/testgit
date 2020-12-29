package com.first.testgit.test.conntroller;


import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;


/**
 * @author:jiaxingxu
 **/
@RestController
@RequestMapping("/test")
public class TestThreadControler {



    @PostMapping("/thread")
    @Async
    void  testThread(Pageable pageable){
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(Thread.currentThread().getName());
    }


    /**
     * 前端传参page 和 size get请求
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




}
