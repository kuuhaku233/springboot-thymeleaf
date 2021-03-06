package com.example.springbootthymeleaf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootthymeleaf.pojo.Log;
import com.example.springbootthymeleaf.view.LogVo;

import java.util.List;

public interface LogService extends IService<Log> {
    List<LogVo> getLogs();

    Integer saveLog(Log log);

    IPage<LogVo> findLogeByPage(String pageSize, String currPage);

    Log findLogById(String id);
}
