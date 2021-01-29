package com.example.springbootthymeleaf.view.service.impl;

import com.example.springbootthymeleaf.view.dao.YoujiDao;
import com.example.springbootthymeleaf.view.entity.Youji;
import com.example.springbootthymeleaf.view.service.YoujiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Youji)表服务实现类
 *
 * @author makejava
 * @since 2021-01-29 08:43:43
 */
@Service("youjiService")
public class YoujiServiceImpl implements YoujiService {
    @Resource
    private YoujiDao youjiDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Youji queryById(Integer id) {
        return this.youjiDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Youji> queryAllByLimit(int offset, int limit) {
        return this.youjiDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param youji 实例对象
     * @return 实例对象
     */
    @Override
    public Youji insert(Youji youji) {
        this.youjiDao.insert(youji);
        return youji;
    }

    /**
     * 修改数据
     *
     * @param youji 实例对象
     * @return 实例对象
     */
    @Override
    public Youji update(Youji youji) {
        this.youjiDao.update(youji);
        return this.queryById(youji.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.youjiDao.deleteById(id) > 0;
    }
}