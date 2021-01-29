package com.example.springbootthymeleaf.view.service.impl;

import com.example.springbootthymeleaf.view.dao.RukuDao;
import com.example.springbootthymeleaf.view.entity.Ruku;
import com.example.springbootthymeleaf.view.service.RukuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Ruku)表服务实现类
 *
 * @author makejava
 * @since 2021-01-29 08:43:36
 */
@Service("rukuService")
public class RukuServiceImpl implements RukuService {
    @Resource
    private RukuDao rukuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Ruku queryById(Integer id) {
        return this.rukuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Ruku> queryAllByLimit(int offset, int limit) {
        return this.rukuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ruku 实例对象
     * @return 实例对象
     */
    @Override
    public Ruku insert(Ruku ruku) {
        this.rukuDao.insert(ruku);
        return ruku;
    }

    /**
     * 修改数据
     *
     * @param ruku 实例对象
     * @return 实例对象
     */
    @Override
    public Ruku update(Ruku ruku) {
        this.rukuDao.update(ruku);
        return this.queryById(ruku.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.rukuDao.deleteById(id) > 0;
    }
}