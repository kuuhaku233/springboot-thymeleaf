package com.example.springbootthymeleaf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootthymeleaf.pojo.Log;
import com.example.springbootthymeleaf.view.LogVo;

import java.util.List;

public interface LogMapper extends BaseMapper<Log> {

    IPage<LogVo> getLogs(Page<LogVo> page);

    Integer saveLog(Log log);
}
