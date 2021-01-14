package com.example.springbootthymeleaf.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;

/**
 * 统一返回类
 *
 * @date： 2021/1/14
 * @author: wbx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    Integer code = 200;
    String msg = "成功";
}
