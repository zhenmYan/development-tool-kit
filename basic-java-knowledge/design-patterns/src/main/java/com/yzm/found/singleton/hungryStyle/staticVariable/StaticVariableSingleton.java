package com.yzm.found.singleton.hungryStyle.staticVariable;

/**
 * ##### 设计模式 design patterns 单例模式
 *
 * 一、分类
 *      1、饿汉
 *          - 类加载时创建
 *          - 创建方式
 *              - 静态变量
 *              - 静态代码块
 *      2、懒汉
 *          - 首次使用时创建
 *          - 创建方式
 *              -
 *
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
