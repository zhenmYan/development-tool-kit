package com.yzm.found.singleton.staticCodeBlock;

/**
 * description: 静态代码块
 *
 * @author yzm
 * @date 2024/4/22
 */
public class StaticCodeBlockSingleton {

    private static StaticCodeBlockSingleton instance;

    private StaticCodeBlockSingleton(){}

    static {
        instance = new StaticCodeBlockSingleton();
    }

    public static StaticCodeBlockSingleton getInstance(){
        return instance;
    }
}
