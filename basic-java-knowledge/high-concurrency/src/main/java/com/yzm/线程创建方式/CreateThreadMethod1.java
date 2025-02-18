package com.yzm.线程创建方式;

/**
 * ##### 并发编程 创建方式的线程
 *
 *      1、四种方式
 *          - 方式一：继承Thread类，重写run方法
 *          - 方式二：实现runnable接口，重写run方法
 *          - 方式三：使用Callable和FutureTask
 *          - 方式四：线程池
 *
 *      2、区别
 *          - 实现runnable接口相比于继承Thread类，将任务创建和执行分离
 *          - runnable与Callable，Callable有返回值和异常需要抛出
 *          - 线程池则对线程资源进行统一管理
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
