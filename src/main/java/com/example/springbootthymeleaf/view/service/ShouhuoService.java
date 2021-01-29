package com.example.springbootthymeleaf.view.service;

import com.example.springbootthymeleaf.view.entity.Shouhuo;

import java.util.List;

/**
 * (Shouhuo)表服务接口
 *
 * @author makejava
 * @since 2021-01-29 08:43:39
 */
public interface ShouhuoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Shouhuo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Shouhuo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param shouhuo 实例对象
     * @return 实例对象
     */
    Shouhuo insert(Shouhuo shouhuo);

    /**
     * 修改数据
     *
     * @param shouhuo 实例对象
     * @return 实例对象
     */
    Shouhuo update(Shouhuo shouhuo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}