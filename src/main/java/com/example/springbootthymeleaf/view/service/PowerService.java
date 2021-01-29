package com.example.springbootthymeleaf.view.service;

import com.example.springbootthymeleaf.view.entity.Power;

import java.util.List;

/**
 * (Power)表服务接口
 *
 * @author makejava
 * @since 2021-01-29 08:43:31
 */
public interface PowerService {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Power queryById(Integer pid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Power> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param power 实例对象
     * @return 实例对象
     */
    Power insert(Power power);

    /**
     * 修改数据
     *
     * @param power 实例对象
     * @return 实例对象
     */
    Power update(Power power);

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pid);

}