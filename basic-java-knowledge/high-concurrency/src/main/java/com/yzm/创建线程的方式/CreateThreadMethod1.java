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
            System.out.println("继承Thread类，重写run方法");
        }
    }

    public static void main(String[] args) {
        CreateThreadMethod11 createThreadMethod11 = new CreateThreadMethod11();
        createThreadMethod11.start();
    }
}
