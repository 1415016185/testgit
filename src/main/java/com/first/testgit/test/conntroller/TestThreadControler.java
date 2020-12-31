package com.first.testgit.test.conntroller;


import com.first.testgit.config.thread.ThreadPoolExecutorUtil;
import com.first.testgit.service.RedisService;
import com.first.testgit.vo.RedisVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;


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

    @PostMapping("/hello")
    String  hello(){
       return "hello";
    }

    @PostMapping("/test")
    void   test(){

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



    @DeleteMapping(value = "/redis")
    public ResponseEntity delete(@RequestBody RedisVo resources){
        redisService.delete(resources.getKey());
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 测试线程池创建线程
     */
    @GetMapping(value = "/se")
    public String se(){
        for (int i = 0; i < 7; i++) {
            ThreadPoolExecutorUtil.getPoll().execute(new threadRunnable());
        }
        return "hrrrr";
    }


    static class threadRunnable implements  Runnable{
        private  String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        threadRunnable(String name) {
            this.name = name;
        }
        threadRunnable() {}


        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "is running!");
            /*    Date date = new Date();
                String strDateFormat = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
                System.out.println(sdf.format(date)+"我是线程"+Thread.currentThread().getName());*/
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static class MyIgnorePolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }
        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            System.err.println( r.toString() + " rejected");
//          System.out.println("completedTaskCount: " + e.getCompletedTaskCount());
        }
    }
}
