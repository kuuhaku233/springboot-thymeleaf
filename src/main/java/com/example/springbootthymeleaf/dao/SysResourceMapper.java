package com.example.springbootthymeleaf.dao;

import com.example.springbootthymeleaf.pojo.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
public interface SysResourceMapper {

    //查询系统资源信息
    List<Resource> getresource(@Param("offset") String offset,
                               @Param("limit") String limit);

    //删除资源记录
    public int deleteResourceById(String reid);

    //修改资源信息
    public int updateResourceMess(Resource resource);

    public Resource updateTest(Resource resource);

    //添加资源 下拉列表的级联
    public List<Resource> getSelectVal(Integer realRejigouId);

    //新增资源记录
    public int saveResource(Resource resource);

    //根据用户id获取 资源
    List<Resource> getRoleLinkByRoleId(Integer roleid);


}
