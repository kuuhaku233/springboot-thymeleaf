package com.example.springbootthymeleaf.view.entity;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2021-01-29 08:43:34
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 692289365030775792L;
    /**
     * 角色id
     */
    private Integer rid;
    /**
     * 角色名称
     */
    private String rname;
    /**
     * 角色编码
     */
    private String rbianma;
    /**
     * 组织id
     */
    private Integer oid;
    /**
     * 角色下人员数
     */
    private String ruser;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRbianma() {
        return rbianma;
    }

    public void setRbianma(String rbianma) {
        this.rbianma = rbianma;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getRuser() {
        return ruser;
    }

    public void setRuser(String ruser) {
        this.ruser = ruser;
    }

}