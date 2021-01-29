package com.example.springbootthymeleaf.view.controller;

import com.example.springbootthymeleaf.view.entity.Shouhuo;
import com.example.springbootthymeleaf.view.service.ShouhuoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Shouhuo)表控制层
 *
 * @author makejava
 * @since 2021-01-29 08:43:39
 */
@RestController
@RequestMapping("shouhuo")
public class ShouhuoController {
    /**
     * 服务对象
     */
    @Resource
    private ShouhuoService shouhuoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Shouhuo selectOne(Integer id) {
        return this.shouhuoService.queryById(id);
    }

}