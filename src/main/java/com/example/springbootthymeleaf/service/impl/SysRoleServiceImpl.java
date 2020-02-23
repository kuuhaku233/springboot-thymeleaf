package com.example.springbootthymeleaf.service.impl;

import com.example.springbootthymeleaf.dao.SysRoleMapper;
import com.example.springbootthymeleaf.pojo.Role;
import com.example.springbootthymeleaf.pojo.User;
import com.example.springbootthymeleaf.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleDao;
    @Override
    public List<Role> getRoles() {
        return sysRoleDao.getRoles();
    }

    @Override
    public int updateRole(Integer rid, String rname) {
        return sysRoleDao.updateRole(rid, rname);
    }

    @Override
    public int deleteRole(Integer rid) {
        return sysRoleDao.deleteRole(rid);
    }

    @Override
    public int saveRole(Role role) {
        return sysRoleDao.saveRole(role);
    }

    @Override
    public List<User> getroleuser(Integer rid) {
        return sysRoleDao.getroleuser(rid);
    }

    @Override
    public Boolean updateUserRole(String[] uid) {
        return sysRoleDao.updateUserRole(uid);
    }
}
