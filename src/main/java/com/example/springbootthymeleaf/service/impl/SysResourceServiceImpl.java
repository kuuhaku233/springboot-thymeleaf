package com.example.springbootthymeleaf.service.impl;

import com.example.springbootthymeleaf.dao.SysResourceMapper;
import com.example.springbootthymeleaf.pojo.Resource;
import com.example.springbootthymeleaf.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysResourceServiceImpl implements SysResourceService {
    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Override
    public List<Resource> getresource(String offset, String limit) {
        return sysResourceMapper.getresource(offset, limit);
    }

    @Override
    public int deleteResourceById(String reid) {
        return sysResourceMapper.deleteResourceById(reid);
    }

    @Override
    public int updateResourceMess(Resource resource) {
        return sysResourceMapper.updateResourceMess(resource);
    }

    @Override
    public Resource updateTest(Resource resource) {
        return sysResourceMapper.updateTest(resource);
    }

    @Override
    public List<Resource> getSelectVal(Integer rejigouid) {
        Integer realRejigouId=rejigouid-1;
        return sysResourceMapper.getSelectVal(realRejigouId);
    }

    @Override
    public int saveResource(Resource resource) {
        return sysResourceMapper.saveResource(resource);
    }

    @Override
    public List<Resource> getRoleLinkByRoleId(Integer roleid) {
        return sysResourceMapper.getRoleLinkByRoleId(roleid);
    }
}
