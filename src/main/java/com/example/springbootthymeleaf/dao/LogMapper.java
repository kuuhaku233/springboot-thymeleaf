package com.example.springbootthymeleaf.dao;

import com.example.springbootthymeleaf.pojo.Log;

import java.util.List;

public interface LogMapper {

    List<Log> getLogs();

    Integer saveLog(Log log);
}
