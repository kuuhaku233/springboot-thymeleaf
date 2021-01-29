package com.example.springbootthymeleaf.view.service.impl;

import com.example.springbootthymeleaf.view.dao.ChukuDao;
import com.example.springbootthymeleaf.view.entity.Chuku;
import com.example.springbootthymeleaf.view.service.ChukuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Chuku)表服务实现类
 *
 * @author makejava
 * @since 2021-01-29 08:43:25
 */
@Service("chukuService")
public class ChukuServiceImpl implements ChukuService {
    @Resource
    private ChukuDao chukuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Chuku queryById(Integer id) {
        return this.chukuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Chuku> queryAllByLimit(int offset, int limit) {
        return this.chukuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param chuku 实例对象
     * @return 实例对象
     */
    @Override
    public Chuku insert(Chuku chuku) {
        this.chukuDao.insert(chuku);
        return chuku;
    }

    /**
     * 修改数据
     *
     * @param chuku 实例对象
     * @return 实例对象
     */
    @Override
    public Chuku update(Chuku chuku) {
        this.chukuDao.update(chuku);
        return this.queryById(chuku.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.chukuDao.deleteById(id) > 0;
    }
}