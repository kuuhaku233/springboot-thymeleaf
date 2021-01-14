package com.example.springbootthymeleaf.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springbootthymeleaf.pojo.Log;
import com.example.springbootthymeleaf.response.ResponseData;
import com.example.springbootthymeleaf.service.LogService;
import com.example.springbootthymeleaf.view.LogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;

/**
 * 测试
 *
 * @date： 2021/1/14
 * @author: wbx
 */
@RestController
@Validated
public class TestController extends BaseController {
    @Autowired
    LogService logService;

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    /**
     * @Description: 分页获取日志信息
     * @Author: WBX
     * @Date: 2021/1/14 11:42
     * @param pageSize: 每页条数
     * @param currPage: 当前页数
     * @return: com.example.springbootthymeleaf.response.Response<com.baomidou.mybatisplus.core.metadata.IPage<com.example.springbootthymeleaf.view.LogVo>>
     **/
    @GetMapping("/getLog")
    public ResponseData<IPage<LogVo>> findLogeByPage(@Max(value = 10,message = "分页不能超过10")@RequestParam(defaultValue = "10") String pageSize,
                                                     @RequestParam(defaultValue = "1") String currPage) {
//        List<LogVo> logeByPage = logService.findLogeByPage(pageSize,currPage);
        IPage<LogVo> logeByPage = logService.findLogeByPage(pageSize, currPage);
        return new ResponseData(logeByPage);
    }

    @GetMapping("/getLogById")
    public ResponseData<Log> getLogById( @Validated Integer id) {
//        List<LogVo> logeByPage = logService.findLogeByPage(pageSize,currPage);
        Log logById = logService.findLogById(id.toString());
        return new ResponseData(logById);
    }

    @PostMapping("/saveLog")
    public ResponseData saveLog(Log log) {
        return new ResponseData(logService.saveLog(log));
    }
}