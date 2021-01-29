package com.example.springbootthymeleaf.view.controller;

import com.example.springbootthymeleaf.view.entity.Ruku;
import com.example.springbootthymeleaf.view.service.RukuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Ruku)表控制层
 *
 * @author makejava
 * @since 2021-01-29 08:43:37
 */
@RestController
@RequestMapping("ruku")
public class RukuController {
    /**
     * 服务对象
     */
    @Resource
    private RukuService rukuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Ruku selectOne(Integer id) {
        return this.rukuService.queryById(id);
    }

}