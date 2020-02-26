package com.example.springbootthymeleaf.dao;

import com.example.springbootthymeleaf.pojo.Log;
import com.example.springbootthymeleaf.view.LogVo;

import java.util.List;

public interface LogMapper {

    List<LogVo> getLogs();

    Integer saveLog(Log log);
}
