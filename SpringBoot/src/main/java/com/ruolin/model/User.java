package com.ruolin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键由数据库自动生成（主要是自动增长型）
    private Long id;
    private String uname;
    private String upwd;
    private String role;

    protected User() {    //无参构造函数,防止直接使用
    }
    public User(Long id, String uname, String upwd, String role) {
        this.id = id;
        this.uname = uname;
        this.upwd = upwd;
        this.role = role;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getUpwd() {
        return upwd;
    }
    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String toString() {
        return String.format("User[id=%d,uname='%s',upwd='%s',role='%s']",id,uname,upwd,role);
    }
}
