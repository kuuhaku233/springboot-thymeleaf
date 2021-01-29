package com.example.springbootthymeleaf.view.service.impl;

import com.example.springbootthymeleaf.view.dao.CarDao;
import com.example.springbootthymeleaf.view.entity.Car;
import com.example.springbootthymeleaf.view.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Car)表服务实现类
 *
 * @author makejava
 * @since 2021-01-29 08:43:22
 */
@Service("carService")
public class CarServiceImpl implements CarService {
    @Resource
    private CarDao carDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Car queryById(Integer id) {
        return this.carDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Car> queryAllByLimit(int offset, int limit) {
        return this.carDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param car 实例对象
     * @return 实例对象
     */
    @Override
    public Car insert(Car car) {
        this.carDao.insert(car);
        return car;
    }

    /**
     * 修改数据
     *
     * @param car 实例对象
     * @return 实例对象
     */
    @Override
    public Car update(Car car) {
        this.carDao.update(car);
        return this.queryById(car.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.carDao.deleteById(id) > 0;
    }
}