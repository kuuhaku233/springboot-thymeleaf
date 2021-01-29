package com.example.springbootthymeleaf.view.controller;

import com.example.springbootthymeleaf.view.entity.Chuku;
import com.example.springbootthymeleaf.view.service.ChukuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Chuku)表控制层
 *
 * @author makejava
 * @since 2021-01-29 08:43:26
 */
@RestController
@RequestMapping("chuku")
public class ChukuController {
    /**
     * 服务对象
     */
    @Resource
    private ChukuService chukuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Chuku selectOne(Integer id) {
        return this.chukuService.queryById(id);
    }

}