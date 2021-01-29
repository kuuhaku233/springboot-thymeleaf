package com.example.springbootthymeleaf.view.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Shouhuo)实体类
 *
 * @author makejava
 * @since 2021-01-29 08:43:39
 */
public class Shouhuo implements Serializable {
    private static final long serialVersionUID = 549342333130416766L;

    private Integer id;
    /**
     * 收件人
     */
    private String username;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态 1.待收货 2.已签收
     */
    private String state;
    /**
     * 货物描述
     */
    private String descs;
    /**
     * 取件地址
     */
    private String addr;
    /**
     * 收货时间
     */
    private Date time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}