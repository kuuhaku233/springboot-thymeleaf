package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.annotation.ALog;
import com.example.springbootthymeleaf.pojo.Log;
import com.example.springbootthymeleaf.service.LogService;
import com.example.springbootthymeleaf.view.LogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/log/")
public class LogController {
    @Autowired
    LogService logService;

    @RequestMapping(value = "getLogs",method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @ALog(desc="查看日志")
    public List<LogVo> getLogs(@RequestParam(defaultValue = "",required = false) String search) {
//        System.out.println(search);
        return logService.getLogs();
    }

    @RequestMapping("saveLog")
    public Integer saveLog(Log log) {
        return logService.saveLog(log);
    }
}
