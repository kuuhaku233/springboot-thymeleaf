package com.example.springbootthymeleaf.view.entity;

import java.io.Serializable;

/**
 * (Resource)实体类
 *
 * @author makejava
 * @since 2021-01-29 08:43:32
 */
public class Resource implements Serializable {
    private static final long serialVersionUID = 179670372031295212L;
    /**
     * 资源id
     */
    private Integer reid;
    /**
     * 资源名称
     */
    private String resourcename;
    /**
     * 资源链接
     */
    private String relink;
    /**
     * 资源编号
     */
    private String rebianhao;
    /**
     * 资源级别
     */
    private Integer rejigouid;
    /**
     * 资源父类id
     */
    private Integer reopjigouid;


    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public String getRelink() {
        return relink;
    }

    public void setRelink(String relink) {
        this.relink = relink;
    }

    public String getRebianhao() {
        return rebianhao;
    }

    public void setRebianhao(String rebianhao) {
        this.rebianhao = rebianhao;
    }

    public Integer getRejigouid() {
        return rejigouid;
    }

    public void setRejigouid(Integer rejigouid) {
        this.rejigouid = rejigouid;
    }

    public Integer getReopjigouid() {
        return reopjigouid;
    }

    public void setReopjigouid(Integer reopjigouid) {
        this.reopjigouid = reopjigouid;
    }

}