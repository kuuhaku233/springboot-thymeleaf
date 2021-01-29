package com.example.springbootthymeleaf.view.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Log)实体类
 *
 * @author makejava
 * @since 2021-01-29 08:43:29
 */
public class Log implements Serializable {
    private static final long serialVersionUID = -71515822573181620L;
    /**
     * id
     */
    private Integer id;
    /**
     * 日志标题
     */
    private String title;
    /**
     * 请求地址
     */
    private String url;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 访问人
     */
    private String username;
    /**
     * 异常情况
     */
    private String exception;
    /**
     * 角色id
     */
    private Integer roleid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

}