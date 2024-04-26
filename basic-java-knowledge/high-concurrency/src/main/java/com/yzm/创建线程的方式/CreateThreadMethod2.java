package com.yzm.创建线程的方式;

/**
 * 创建线程的方式二：实现runnable接口，重写run方法
 *
 * @author: yan
 * @description:
 * @create: 2023-02-21 10:43
 **/
public class CreateThreadMethod2 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("创建线程的方式二：实现runnable接口，重写run方法");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }


}
