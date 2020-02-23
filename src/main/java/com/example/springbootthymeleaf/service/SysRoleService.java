package com.example.springbootthymeleaf.service;

import com.example.springbootthymeleaf.pojo.Role;
import com.example.springbootthymeleaf.pojo.User;

import java.util.List;

public interface SysRoleService {

    List<Role> getRoles();

    int updateRole(Integer rid, String rname);

    int deleteRole(Integer rid);

    int saveRole(Role role);

    List<User> getroleuser(Integer rid);

    Boolean updateUserRole(String[] uid);
}
