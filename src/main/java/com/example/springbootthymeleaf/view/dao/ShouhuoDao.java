package com.example.springbootthymeleaf.view.dao;

import com.example.springbootthymeleaf.view.entity.Shouhuo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Shouhuo)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-29 08:43:39
 */
public interface ShouhuoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Shouhuo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Shouhuo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shouhuo 实例对象
     * @return 对象列表
     */
    List<Shouhuo> queryAll(Shouhuo shouhuo);

    /**
     * 新增数据
     *
     * @param shouhuo 实例对象
     * @return 影响行数
     */
    int insert(Shouhuo shouhuo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shouhuo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Shouhuo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shouhuo> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Shouhuo> entities);

    /**
     * 修改数据
     *
     * @param shouhuo 实例对象
     * @return 影响行数
     */
    int update(Shouhuo shouhuo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}