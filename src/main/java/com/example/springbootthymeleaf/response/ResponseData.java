package com.example.springbootthymeleaf.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date： 2021/1/14
 * @author: wbx
 *//*
 * @Description:
 * @Author: WBX 
 * @Date: $ $
 $
 $
 **/
@Data
@NoArgsConstructor
public class ResponseData<T> extends Response {
    T data;
    public ResponseData(T data) {
        super();
        this.data = data;
    }
}
