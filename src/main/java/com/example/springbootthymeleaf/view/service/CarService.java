package com.example.springbootthymeleaf.view.service;

import com.example.springbootthymeleaf.view.entity.Car;

import java.util.List;

/**
 * (Car)表服务接口
 *
 * @author makejava
 * @since 2021-01-29 08:43:22
 */
public interface CarService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Car queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Car> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param car 实例对象
     * @return 实例对象
     */
    Car insert(Car car);

    /**
     * 修改数据
     *
     * @param car 实例对象
     * @return 实例对象
     */
    Car update(Car car);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}