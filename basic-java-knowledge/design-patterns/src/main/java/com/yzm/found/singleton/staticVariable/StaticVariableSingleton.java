package com.yzm.found.singleton.staticVariable;

/**
 * ##### 设计模式 单例模式
 *
 * 一、分类
 *      1、饿汉
 *          - 类加载时创建
 *      2、懒汉
 *          - 首次使用时创建
 *
 * 二、实现方式
 *      1、静态方法
 *      2、静态代码块
 *
 * @author yzm
 * @date 2024/4/22
 */
public class StaticVariableSingleton {

    private static StaticVariableSingleton instance = new StaticVariableSingleton();

    private StaticVariableSingleton(){}

    public static StaticVariableSingleton getSingleton(){
        return instance;
    }

    public static void main(String[] args) {
        StaticVariableSingleton singleton1 = StaticVariableSingleton.getSingleton();
        StaticVariableSingleton singleton2 = StaticVariableSingleton.getSingleton();
        System.out.println(singleton1.equals(singleton2));
    }
}
