package com.smile.pojo;

import java.io.Serializable;

/**
 * @时间 2020/3/4 9:03
 * @作者 liutao
 * @描述
 */
public class User implements Serializable {

    private int id;
    private String name;
    private String no;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", no='" + no + '\'' +
                '}';
    }
}
