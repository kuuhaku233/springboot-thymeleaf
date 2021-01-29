package com.example.springbootthymeleaf.view.service.impl;

import com.example.springbootthymeleaf.view.dao.ResourceDao;
import com.example.springbootthymeleaf.view.entity.Resource;
import com.example.springbootthymeleaf.view.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Resource)表服务实现类
 *
 * @author makejava
 * @since 2021-01-29 08:43:33
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceDao resourceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param reid 主键
     * @return 实例对象
     */
    @Override
    public Resource queryById(Integer reid) {
        return this.resourceDao.queryById(reid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Resource> queryAllByLimit(int offset, int limit) {
        return this.resourceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param resource 实例对象
     * @return 实例对象
     */
    @Override
    public Resource insert(Resource resource) {
        this.resourceDao.insert(resource);
        return resource;
    }

    /**
     * 修改数据
     *
     * @param resource 实例对象
     * @return 实例对象
     */
    @Override
    public Resource update(Resource resource) {
        this.resourceDao.update(resource);
        return this.queryById(resource.getReid());
    }

    /**
     * 通过主键删除数据
     *
     * @param reid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer reid) {
        return this.resourceDao.deleteById(reid) > 0;
    }
}