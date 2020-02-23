package com.example.springbootthymeleaf.dao;

import com.example.springbootthymeleaf.pojo.Power;
import com.example.springbootthymeleaf.view.PowerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface SysPowerMapper {


    //获取选中角色锁具有的资源
    public List<PowerVO> getPowerResource(Integer rid);

    /**
     *
     * @param rid  用户id
     * @return t/f
     */

    public int updateRolePower(/*@Param("rid") Integer rid,
                               @Param("arr") String[] arr*/ Map map);

    int deleteResourceByRid(Integer rid);
}
