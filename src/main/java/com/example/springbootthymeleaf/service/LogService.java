package com.example.springbootthymeleaf.service;

import com.example.springbootthymeleaf.pojo.Log;
import com.example.springbootthymeleaf.view.LogVo;

import java.util.List;

public interface LogService {
    List<LogVo> getLogs();

    Integer saveLog(Log log);
}
