package com.yzm.found.singleton.lazyStyle.doubleLock;

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
 *              - 双重锁检验
 *              - 静态内部类

 *
 * description: 双重锁检验
 *
 *  1、细节
 *      - 需要将singleton属性设置为private类型，不然就可以直接通过类名获取
 *      - 需要将singleton属性设置为volatile类型，防止指令重排
 *      - 构造方法也要设置为private，不然可以直接new对象
 *      - 方法也要设置为static的，可以通过类名直接调用
 *
 *  2、两次判空的作用
 *      - 第一次：防止进入锁的竞争
 *      - 第二次：防止创建多个对象
 *          - 解释：如果没有第二次判断，线程A、B都执行到加锁的代码，那么两个线程都会创建对象
 *
 *  3、volatile防止指令重排
 *      - 创建对象会有三个步骤
 *          - 分配空间
 *          - 初始化
 *          - 将指针指向
 *      - 指令重排变成1-3-2
 *      - 当多线程时，线程T1执行了1和3，此时T2调用 getInstance() 后发现 singleton 不为空，
 *          因此返回 singleton， 但是此时的 singleton 还没有被初始化
 *
 * @author yzm
 * @date 2024/4/26
 */
public class DoubleLockSingleton {

    private DoubleLockSingleton(){}

    private volatile static DoubleLockSingleton instance;

    public static DoubleLockSingleton getInstance(){
        if (instance == null) {
            synchronized (DoubleLockSingleton.class){
                if (instance == null) {
                    instance = new DoubleLockSingleton();
                }
            }
        }
        return instance;
    }
}
