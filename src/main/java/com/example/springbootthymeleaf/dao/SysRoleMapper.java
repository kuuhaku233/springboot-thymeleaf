package com.example.springbootthymeleaf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootthymeleaf.pojo.Role;
import com.example.springbootthymeleaf.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
public interface SysRoleMapper extends BaseMapper<Role> {

    //查询所有角色
    List<Role> getRoles();

    /**
     *  修改角色信息
     * @param rid  角色id
     * @param rname  角色名称
     * @return
     */
    int updateRole(@Param("rid") Integer rid,
                   @Param("rname") String rname);

    /**
     *  删除角色记录
     * @param rid  要删角色的id
     * @return
     */
    int deleteRole(Integer rid);

    //添加角色
    int saveRole(Role role);

    List<User> getroleuser(Integer rid);

    Boolean updateUserRole(String[] uid);
}
