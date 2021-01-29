package com.example.springbootthymeleaf.view.controller;

import com.example.springbootthymeleaf.view.entity.Car;
import com.example.springbootthymeleaf.view.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Car)表控制层
 *
 * @author makejava
 * @since 2021-01-29 08:43:22
 */
@RestController
@RequestMapping("car")
public class CarController {
    /**
     * 服务对象
     */
    @Resource
    private CarService carService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Car selectOne(Integer id) {
        return this.carService.queryById(id);
    }

}