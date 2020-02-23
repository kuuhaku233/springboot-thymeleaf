package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.pojo.Log;
import com.example.springbootthymeleaf.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/log/")
public class LogController {
    @Autowired
    LogService logService;

    @RequestMapping("getLogs")
    @ResponseBody
    public List<Log> getLogs() {
        return logService.getLogs();
    }

    @RequestMapping("saveLog")
    public Integer saveLog(Log log) {
        return logService.saveLog(log);
    }
}
