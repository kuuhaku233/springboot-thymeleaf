package com.example.springbootthymeleaf.view.controller;

import com.example.springbootthymeleaf.view.entity.Power;
import com.example.springbootthymeleaf.view.service.PowerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Power)表控制层
 *
 * @author makejava
 * @since 2021-01-29 08:43:31
 */
@RestController
@RequestMapping("power")
public class PowerController {
    /**
     * 服务对象
     */
    @Resource
    private PowerService powerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Power selectOne(Integer id) {
        return this.powerService.queryById(id);
    }

}