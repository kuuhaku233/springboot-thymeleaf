package com.example.springbootthymeleaf.pojo;


public class Role {
    private Integer rid;
    private String rname;
    private String rbianma;
    private Integer oid;
    private String ruser;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer id) {
        this.rid = id;
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

    public void setRbianma(String rbainma) {
        this.rbianma = rbainma;
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

    public Role() {
    }

    public Role(Integer id, String rname, String rbianma, Integer oid, String ruser) {

        this.rid = id;
        this.rname = rname;
        this.rbianma = rbianma;
        this.oid = oid;
        this.ruser = ruser;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + rid +
                ", rname='" + rname + '\'' +
                ", rbainma='" + rbianma + '\'' +
                ", oid=" + oid +
                ", ruser='" + ruser + '\'' +
                '}';
    }
}
