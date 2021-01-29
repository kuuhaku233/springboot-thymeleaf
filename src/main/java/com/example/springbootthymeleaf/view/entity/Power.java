package com.example.springbootthymeleaf.view.entity;

import java.io.Serializable;

/**
 * (Power)实体类
 *
 * @author makejava
 * @since 2021-01-29 08:43:31
 */
public class Power implements Serializable {
    private static final long serialVersionUID = 981593351084410241L;
    /**
     * 权限id
     */
    private Integer pid;
    /**
     * 角色id
     */
    private Integer rid;
    /**
     * 资源id
     */
    private Integer reid;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

}