package com.example.springbootthymeleaf.view.controller;

import com.example.springbootthymeleaf.view.entity.Youji;
import com.example.springbootthymeleaf.view.service.YoujiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Youji)表控制层
 *
 * @author makejava
 * @since 2021-01-29 08:43:43
 */
@RestController
@RequestMapping("youji")
public class YoujiController {
    /**
     * 服务对象
     */
    @Resource
    private YoujiService youjiService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Youji selectOne(Integer id) {
        return this.youjiService.queryById(id);
    }

}