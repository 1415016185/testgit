package com.first.testgit.exception;

import com.first.testgit.utils.ApiCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author:jiaxingxu
 **/
@Getter
public class BadLimitRequestException extends RuntimeException{

    private Integer status = ApiCode.BAD_LIMIT_EXCEPTION.getCode();

    public BadLimitRequestException(String msg){
        super(msg);
    }

    public BadLimitRequestException(HttpStatus status, String msg){
        super(msg);
        this.status = status.value();
    }
}
