package com.yzm.互斥锁;

/**
 * synchronized
 *
 * @author yzm
 * @date 2024/5/24
 */
public class SynchronizedTest {
    Object o = new Object();
    static Object staticO = new Object();
    public static void main(String[] args) {

    }

//    1、静态方法内无法对非静态对象加锁
//    public static void o(){
//        synchronized (o){
//            System.out.println(1);
//        }
//    }

    // 2、静态方法可以对静态对象加锁
    public static void staticO(){
        synchronized (staticO){
            System.out.println(1);
        }
    }
    // 3、静态对象可以对静态内部类加锁
    public static void staticCls(){
        synchronized (StaticCls.class){
            System.out.println(1);
        }
    }

    static class StaticCls {}
}
