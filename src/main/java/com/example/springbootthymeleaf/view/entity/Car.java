package com.example.springbootthymeleaf.view.entity;

import java.io.Serializable;

/**
 * (Car)实体类
 *
 * @author makejava
 * @since 2021-01-29 08:43:20
 */
public class Car implements Serializable {
    private static final long serialVersionUID = -35204219157091725L;
    /**
     * 车牌号
     */
    private String cardnu;
    /**
     * 车辆id
     */
    private Integer id;
    /**
     * 所属人
     */
    private String username;
    /**
     * 1.工作中 2.休息中
     */
    private String state;


    public String getCardnu() {
        return cardnu;
    }

    public void setCardnu(String cardnu) {
        this.cardnu = cardnu;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}