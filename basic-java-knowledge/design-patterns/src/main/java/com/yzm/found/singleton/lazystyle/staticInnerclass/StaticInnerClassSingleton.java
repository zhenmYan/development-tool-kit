package com.yzm.found.singleton.lazystyle.staticInnerclass;

/**
 * description: 静态内部类
 *
 *      1、JVM在加载外部类时，不会加载静态内部类
 *      只有在调用静态内部类的方法时才会被加载，并初始化其静态属性
 *
 *      2、一种比较优雅的方式，很多开源框架使用该方式
 *      即线程安全，又懒加载
 *
 * @author yzm
 * @date 2024/4/26
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){}

    // INSTANCE对象只会在首次调用时创建一次
    public static class Builder{
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance(){
        return Builder.INSTANCE;
    }

    public static void main(String[] args) {
        StaticInnerClassSingleton singleton1 = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton singleton2 = StaticInnerClassSingleton.getInstance();
        System.out.println(singleton1.equals(singleton2));
    }
}
