package com.yzm.创建线程的方式;

/**
 * 创建线程的方式一：继承Thread类，重写run方法
 *
 * @author: yan
 * @description:
 * @create: 2023-02-21 10:49
 **/
public class CreateThreadMethod1 {

    static class CreateThreadMethod11 extends Thread {
        @Override
        public void run() {
            System.out.println("创建线程的方式一：继承Thread类，重写run方法");
        }
    }

    public static void main(String[] args) {
        CreateThreadMethod11 t0 = new CreateThreadMethod11();
        t0.start();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("创建线程的方式一：直接调用Thread，重写run方法");
            }
        };

        Thread t2 = new Thread(
                ()->{System.out.println("创建线程的方式一：lambda表达式");}
            );
        t1.start();
        t2.start();
    }
}
