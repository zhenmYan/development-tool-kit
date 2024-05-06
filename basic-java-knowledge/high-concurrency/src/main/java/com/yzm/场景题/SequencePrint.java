package com.yzm.场景题;

import lombok.extern.slf4j.Slf4j;

/**
 * ##### 并发编程 顺序打印
 *
 * @author yzm
 * @date 2024/5/6
 */
@Slf4j
public class SequencePrint {

    public static void main(String[] args) throws InterruptedException {
        // join方法
        m1();
        // wait方法
//        m2();
    }

    // join方法
    private static void m1() throws InterruptedException {
        Thread t1 = new Thread(()->{
            log.debug("join方法 : 线程t1开始执行");
        });
        Thread t2 = new Thread(()->{
            log.debug("join方法 : 线程t2开始执行");
        });
        t1.start();
        t1.join();
        t2.start();
    }

    // wait方法
//    private static void m2() throws InterruptedException {
//        final Object o = new Object();
//        Thread t1 = new Thread(()->{
//            synchronized (o){
//                o.notify();
//                log.debug("wait方法 : 线程t1开始执行");
//            }
//        });
//        Thread t2 = new Thread(()->{
//            synchronized (o){
//                try {
//                    o.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                log.debug("wait方法 : 线程t2开始执行");
//            }
//        });
//        t1.start();
//        t2.start();
//    }
}
