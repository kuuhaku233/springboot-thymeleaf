package com.example.springbootthymeleaf.view.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Youji)实体类
 *
 * @author makejava
 * @since 2021-01-29 08:43:43
 */
public class Youji implements Serializable {
    private static final long serialVersionUID = -23811742942920147L;

    private Integer id;
    /**
     * 快递单号
     */
    private String danhao;
    /**
     * 寄件人姓名
     */
    private String username;
    /**
     * 收件人姓名
     */
    private String tousername;
    /**
     * 收件人电话
     */
    private String phone;
    /**
     * 收件人地址
     */
    private String station;
    /**
     * 发件人地址
     */
    private String curstation;
    /**
     * 邮寄时间
     */
    private Date time;
    /**
     * 1.待发货 2.已发货
     */
    private String state;
    /**
     * 描述
     */
    private String descs;
    /**
     * 发件人电话
     */
    private String fromphone;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDanhao() {
        return danhao;
    }

    public void setDanhao(String danhao) {
        this.danhao = danhao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTousername() {
        return tousername;
    }

    public void setTousername(String tousername) {
        this.tousername = tousername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getCurstation() {
        return curstation;
    }

    public void setCurstation(String curstation) {
        this.curstation = curstation;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public String getFromphone() {
        return fromphone;
    }

    public void setFromphone(String fromphone) {
        this.fromphone = fromphone;
    }

}