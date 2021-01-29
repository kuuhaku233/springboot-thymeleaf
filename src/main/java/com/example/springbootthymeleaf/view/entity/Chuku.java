package com.example.springbootthymeleaf.view.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Chuku)实体类
 *
 * @author makejava
 * @since 2021-01-29 08:43:25
 */
public class Chuku implements Serializable {
    private static final long serialVersionUID = -80604708371315588L;
    /**
     * id
     */
    private Integer id;
    /**
     * 出库地址 跟入库地址相同
     */
    private String laststation;
    /**
     * 下站地址
     */
    private String nextstation;
    /**
     * 出库时间 当前时间
     */
    private Date time;
    /**
     * 出库人用户名
     */
    private String username;
    /**
     * 添加的描述
     */
    private String descs;
    /**
     * 状态:2.待出库 1. 已出库
     */
    private String state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLaststation() {
        return laststation;
    }

    public void setLaststation(String laststation) {
        this.laststation = laststation;
    }

    public String getNextstation() {
        return nextstation;
    }

    public void setNextstation(String nextstation) {
        this.nextstation = nextstation;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}