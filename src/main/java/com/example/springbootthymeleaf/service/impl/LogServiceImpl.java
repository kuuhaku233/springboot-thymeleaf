package com.example.springbootthymeleaf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootthymeleaf.dao.LogMapper;
import com.example.springbootthymeleaf.dao.SysRoleMapper;
import com.example.springbootthymeleaf.pojo.Log;
import com.example.springbootthymeleaf.pojo.Role;
import com.example.springbootthymeleaf.service.LogService;
import com.example.springbootthymeleaf.service.SysRoleService;
import com.example.springbootthymeleaf.view.LogVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper,Log> implements LogService {
    @Autowired
    LogMapper logMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public List<LogVo> getLogs() {
        return null;
    }

    @Override
    public Integer saveLog(Log log) {
        if (log != null) {
            boolean save = save(log);
            if (save) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public IPage<LogVo> findLogeByPage(String pageSize, String currPage) {
        QueryWrapper<Log> queryWrapper = new QueryWrapper();
        Page<LogVo> page = new Page<>(Long.parseLong(currPage), Long.parseLong(pageSize));
        IPage<LogVo> logs = logMapper.getLogs(page);
//        List<Log> list = list(queryWrapper);
//        List<LogVo> result = new ArrayList<>();
//        list.stream().forEach(log -> {
//            LogVo logVo = new LogVo();
//            BeanUtils.copyProperties(log,logVo);
//            QueryWrapper<Role> queryWrapper1 = new QueryWrapper<>();
//            Role role = sysRoleMapper.selectById(log.getRoleid());
//            logVo.setRname(role.getRname());
//            result.add(logVo);
//        });
         return logs;
    }

    @Override
    public Log findLogById(String id) {
        return logMapper.selectById(id);
    }
}
