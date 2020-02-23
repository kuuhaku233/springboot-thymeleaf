package com.example.springbootthymeleaf.service;

import com.example.springbootthymeleaf.pojo.Resource;

import java.util.List;

public interface SysResourceService {
    List<Resource> getresource(String offset, String limit);

    //删除资源记录
    public int deleteResourceById(String reid);

    //修改资源信息
    public int updateResourceMess(Resource resource);

    public Resource updateTest(Resource resource);

    //添加资源 下拉列表的级联
    public List<Resource> getSelectVal(Integer rejigouid);

    //新增资源记录
    public int saveResource(Resource resource);

    //根据用户id获取 资源
    List<Resource> getRoleLinkByRoleId(Integer roleid);
}
