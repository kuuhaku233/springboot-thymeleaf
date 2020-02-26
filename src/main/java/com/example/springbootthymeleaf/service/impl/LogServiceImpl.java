package com.example.springbootthymeleaf.service.impl;

import com.example.springbootthymeleaf.dao.LogMapper;
import com.example.springbootthymeleaf.pojo.Log;
import com.example.springbootthymeleaf.service.LogService;
import com.example.springbootthymeleaf.view.LogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;
    @Override
    public List<LogVo> getLogs() {
        return logMapper.getLogs();
    }

    @Override
    public Integer saveLog(Log log) {
        return logMapper.saveLog(log);
    }
}
