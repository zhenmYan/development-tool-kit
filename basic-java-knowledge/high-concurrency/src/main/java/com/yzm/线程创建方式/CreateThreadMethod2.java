package com.yzm.线程创建方式;

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
        Thread t1 = new Thread(runnable);
        t1.start();

        Runnable runnable1 = ()->{
            System.out.println("创建线程的方式二：lambda表达式");
        };
        Thread t2 = new Thread(runnable1);
        t2.start();
    }


}
