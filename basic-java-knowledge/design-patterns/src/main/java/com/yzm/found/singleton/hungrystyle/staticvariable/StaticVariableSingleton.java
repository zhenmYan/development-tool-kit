package com.yzm.found.singleton.hungrystyle.staticvariable;

/**
 *  静态变量
 *
 * @author yzm
 * @date 2024/4/22
 */
public class StaticVariableSingleton {

    private static StaticVariableSingleton instance = new StaticVariableSingleton();

    private StaticVariableSingleton(){}

    public static StaticVariableSingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        StaticVariableSingleton singleton1 = StaticVariableSingleton.getInstance();
        StaticVariableSingleton singleton2 = StaticVariableSingleton.getInstance();
        System.out.println(singleton1.equals(singleton2));
    }
}
