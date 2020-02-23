package com.example.springbootthymeleaf.service;

import com.example.springbootthymeleaf.pojo.Power;
import com.example.springbootthymeleaf.view.PowerVO;

import java.util.List;

public interface SysPowerService {

    //获取选中角色锁具有的资源
    public List<PowerVO> getPowerResource(Integer rid);

    //修改用户资源
    public int updateRolePower(Integer rid, String[] arr);

    int deleteResourceByRid(Integer rid);
}
