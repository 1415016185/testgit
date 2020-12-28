package com.first.testgit.controller;


import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:jiaxingxu
 **/
@RestController
@RequestMapping("/test")
public class TestControler {



    @PostMapping("/thread")
    @Async
    void  testThread(){
        System.out.println(Thread.currentThread().getName());
    }


    @PostMapping("/thread2")
    void  testThread2(){

    }


}
