package com.lquan.bean;

/**
 * @author lquan
 * @create 2022- 11-26 下午4:31
 * @description
 */
public class Pet {
    public Pet() {
    }

    public Pet(String name) {
        this.name = name;
    }

    /**
     * name : tomcat
     */

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
