package com.example.springbootthymeleaf.pojo;


public class Resource {
    private Integer reid;
    private String resourcename;
    private String relink;
    private String rebianhao;
    private Integer rejigouid;
    private Integer reopjigouid;

    @Override
    public String toString() {
        return "Resource{" +
                "reid=" + reid +
                ", resourcename='" + resourcename + '\'' +
                ", relink='" + relink + '\'' +
                ", rebianhao='" + rebianhao + '\'' +
                ", rejigouid=" + rejigouid +
                ", reopjigouid=" + reopjigouid +
                '}';
    }

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

    public Resource(Integer reid, String resourcename, String relink, String rebianhao, Integer rejigouid, Integer reopjigouid) {
        this.reid = reid;
        this.resourcename = resourcename;
        this.relink = relink;
        this.rebianhao = rebianhao;
        this.rejigouid = rejigouid;
        this.reopjigouid = reopjigouid;
    }

    public Resource() {

    }
}
