package com.gecx.vo;

import java.io.Serializable;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/4/17 17:48
 */
public class Users implements Serializable {
    private String name;
    private int age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
