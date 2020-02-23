package com.example.springbootthymeleaf.pojo;


public class Power {
    private Integer pid;
    private Integer rid;

    @Override
    public String toString() {
        return "Power{" +
                "pid=" + pid +
                ", rid=" + rid +
                ", reid=" + reid +
                '}';
    }

    public Power() {
    }

    public Power(Integer pid, Integer rid, Integer reid) {

        this.pid = pid;
        this.rid = rid;
        this.reid = reid;
    }

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

    private Integer reid;
}
