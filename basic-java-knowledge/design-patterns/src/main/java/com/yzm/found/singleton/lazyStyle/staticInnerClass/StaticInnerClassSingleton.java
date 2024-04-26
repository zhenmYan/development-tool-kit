package com.yzm.found.singleton.lazyStyle.staticInnerClass;

import com.yzm.found.singleton.hungryStyle.staticVariable.StaticVariableSingleton;

/**
 * description: 静态内部类
 *
 *      JVM在加载外部类时，不会加载静态内部类
 *      只有在调用静态内部类的方法时才会被加载，并初始化其静态属性
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
