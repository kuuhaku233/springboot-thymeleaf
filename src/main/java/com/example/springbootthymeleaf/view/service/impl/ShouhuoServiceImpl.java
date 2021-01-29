package com.example.springbootthymeleaf.view.service.impl;

import com.example.springbootthymeleaf.view.dao.ShouhuoDao;
import com.example.springbootthymeleaf.view.entity.Shouhuo;
import com.example.springbootthymeleaf.view.service.ShouhuoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Shouhuo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-29 08:43:39
 */
@Service("shouhuoService")
public class ShouhuoServiceImpl implements ShouhuoService {
    @Resource
    private ShouhuoDao shouhuoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Shouhuo queryById(Integer id) {
        return this.shouhuoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Shouhuo> queryAllByLimit(int offset, int limit) {
        return this.shouhuoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param shouhuo 实例对象
     * @return 实例对象
     */
    @Override
    public Shouhuo insert(Shouhuo shouhuo) {
        this.shouhuoDao.insert(shouhuo);
        return shouhuo;
    }

    /**
     * 修改数据
     *
     * @param shouhuo 实例对象
     * @return 实例对象
     */
    @Override
    public Shouhuo update(Shouhuo shouhuo) {
        this.shouhuoDao.update(shouhuo);
        return this.queryById(shouhuo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.shouhuoDao.deleteById(id) > 0;
    }
}