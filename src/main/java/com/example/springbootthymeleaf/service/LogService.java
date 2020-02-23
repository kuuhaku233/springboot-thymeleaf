package com.example.springbootthymeleaf.service;

import com.example.springbootthymeleaf.pojo.Log;

import java.util.List;

public interface LogService {
    List<Log> getLogs();

    Integer saveLog(Log log);
}
