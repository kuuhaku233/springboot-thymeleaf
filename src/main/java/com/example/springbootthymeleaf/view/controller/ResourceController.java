package com.example.springbootthymeleaf.view.controller;

import com.example.springbootthymeleaf.view.entity.Resource;
import com.example.springbootthymeleaf.view.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Resource)表控制层
 *
 * @author makejava
 * @since 2021-01-29 08:43:33
 */
@RestController
@RequestMapping("resource")
public class ResourceController {
    /**
     * 服务对象
     */
    @Autowired
    private ResourceService resourceService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Resource selectOne(Integer id) {
        return this.resourceService.queryById(id);
    }

}