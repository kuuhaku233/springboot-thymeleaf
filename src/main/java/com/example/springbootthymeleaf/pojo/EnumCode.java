package com.example.springbootthymeleaf.pojo;

/**
 * 枚举
 *
 * @date： 2021/1/15
 * @author: wbx
 */
public enum EnumCode {

    SUCCESS(200, "成功");


    /**
     * @Description: 返回码
     * @Author: WBX
     * @Date: 2021/1/15 11:12
     **/
    int code;
    /**
     * @Description: 返回消息
     * @Author: WBX
     * @Date: 2021/1/15 11:11
     **/
    String msg;

    EnumCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
