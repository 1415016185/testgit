package com.first.testgit.test.conntroller;


import com.first.testgit.utils.anno.ValidRequest;
import com.first.testgit.vo.TestValid;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @author:jiaxingxu
 **/
@RestController
@RequestMapping("/cache")
public class TestCacheController {

    @RequestMapping("/testCacheable")
    @Cacheable(value = "test",key = "#id")
    public String  testCacheable(@RequestParam("id") Integer id){
          return  "我是"+id;
    }

    @PostMapping("/valid")
    @ValidRequest
    public ResponseEntity testValid(@Valid  @RequestBody
                                            TestValid testVaild , BindingResult bindingResult){
        System.out.println("xxx");
        return  new ResponseEntity(HttpStatus.OK);
    }

}
