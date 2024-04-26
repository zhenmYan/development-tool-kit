package com.yzm.found.singleton.hungrystyle.enumsingleton;

/**
 * description: 枚举类型
 *
 *      饿汉式
 *
 * @author yzm
 * @date 2024/4/26
 */
public enum EnumSingleton {
    INSTANCE;

    public static void main(String[] args) {
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;
        System.out.println(singleton1.equals(singleton2));
    }
}
