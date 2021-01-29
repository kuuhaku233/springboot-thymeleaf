package com.example.springbootthymeleaf.view.service.impl;

import com.example.springbootthymeleaf.view.dao.PowerDao;
import com.example.springbootthymeleaf.view.entity.Power;
import com.example.springbootthymeleaf.view.service.PowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Power)表服务实现类
 *
 * @author makejava
 * @since 2021-01-29 08:43:31
 */
@Service("powerService")
public class PowerServiceImpl implements PowerService {
    @Resource
    private PowerDao powerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    @Override
    public Power queryById(Integer pid) {
        return this.powerDao.queryById(pid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Power> queryAllByLimit(int offset, int limit) {
        return this.powerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param power 实例对象
     * @return 实例对象
     */
    @Override
    public Power insert(Power power) {
        this.powerDao.insert(power);
        return power;
    }

    /**
     * 修改数据
     *
     * @param power 实例对象
     * @return 实例对象
     */
    @Override
    public Power update(Power power) {
        this.powerDao.update(power);
        return this.queryById(power.getPid());
    }

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pid) {
        return this.powerDao.deleteById(pid) > 0;
    }
}