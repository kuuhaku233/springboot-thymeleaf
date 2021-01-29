package com.example.springbootthymeleaf.view.service;

import com.example.springbootthymeleaf.view.entity.Chuku;

import java.util.List;

/**
 * (Chuku)表服务接口
 *
 * @author makejava
 * @since 2021-01-29 08:43:25
 */
public interface ChukuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Chuku queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Chuku> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param chuku 实例对象
     * @return 实例对象
     */
    Chuku insert(Chuku chuku);

    /**
     * 修改数据
     *
     * @param chuku 实例对象
     * @return 实例对象
     */
    Chuku update(Chuku chuku);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}