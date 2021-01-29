package com.first.testgit.utils.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jiaxingxu
 **/
@Aspect
@Component
public class vaildAspect {

    @Around(value = "@annotation(com.first.testgit.utils.anno.ValidRequest)")
    public ResponseEntity beforeVaild(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        ArrayList<String> strings = new ArrayList<>();
        for (Object arg : args) {
            if(arg instanceof BindingResult){
               BindingResult bindingResult= (BindingResult)arg;
               if(bindingResult.hasErrors()){
                   //bindingResult.getFieldError().getField()
                   List<FieldError> fieldErrors = bindingResult.getFieldErrors();
                   for (FieldError fieldError : fieldErrors) {
                       if(!StringUtils.isBlank(fieldError.getDefaultMessage())){
                           strings.add(fieldError.getDefaultMessage());
                       }
                   }
               }
            }
        }
        if(!CollectionUtils.isEmpty(strings)){
            return new ResponseEntity(strings, HttpStatus.NOT_FOUND);
        }
        return  (ResponseEntity)joinPoint.proceed();

    }
}
