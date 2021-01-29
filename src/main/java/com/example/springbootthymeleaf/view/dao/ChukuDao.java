package com.example.springbootthymeleaf.view.dao;

import com.example.springbootthymeleaf.view.entity.Chuku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Chuku)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-29 08:43:25
 */
public interface ChukuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Chuku queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Chuku> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param chuku 实例对象
     * @return 对象列表
     */
    List<Chuku> queryAll(Chuku chuku);

    /**
     * 新增数据
     *
     * @param chuku 实例对象
     * @return 影响行数
     */
    int insert(Chuku chuku);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Chuku> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Chuku> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Chuku> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Chuku> entities);

    /**
     * 修改数据
     *
     * @param chuku 实例对象
     * @return 影响行数
     */
    int update(Chuku chuku);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}