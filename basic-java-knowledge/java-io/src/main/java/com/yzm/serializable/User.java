package com.yzm.serializable;

import java.io.Serializable;

/**
 * description:
 *
 * @author yzm
 * @date 2024/5/15
 */
public class User implements Serializable {

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private Integer age;


    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
