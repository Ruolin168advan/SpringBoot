package com.ruolin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class equipment {

    private Long num;
    private String id;
    private String group;
    private String ename;
    private String etype;
    private String address;

    protected equipment(){

    }
    public equipment(Long num, String id, String group,String ename, String etype, String address) {
        this.address = address;
        this.ename = ename;
        this.etype = etype;
        this.group = group;
        this.id = id;
        this.num = num;
    }
    public Long getNum() {
        return num;
    }
    public void setNum(Long num) {
        this.num = num;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String uname) {
        this.ename = ename;
    }
    public String getEtype() {
        return etype;
    }
    public void setEtype(String uname) {
        this.etype = etype;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public String toString() {
        return String.format("User[num=%d,id='%s',group='%s',ename='%s',etype='%s',address='%s']",num,id,group,ename,etype,address);
    }
}
