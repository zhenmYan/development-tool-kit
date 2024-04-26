package com.yzm.场景题;


import java.util.concurrent.CountDownLatch;

/**
 * description:
 *
 * @author 颜真明
 * @date 2024/3/19  14:07
 */
public class ConcurrentABFiveMin {

    public static void main(String[] args) throws InterruptedException{

        Thread t1 = new Thread(()->{
            while(true) {
                Thread current = Thread.currentThread();
                if (current.isInterrupted()) {
                    System.out.println("liaolihoushi");
                    break;
                }
                try{
                    Thread.sleep(300000);
                }catch (InterruptedException e) {
                    current.interrupt();
                }
            }
        });
//        CountDownLatch countDownLatch = new CountDownLatch(2);
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                Thread.sleep(5, 300000);
//                System.out.println("线程执行了五分钟");
//                countDownLatch.countDown();
//            }
//        };
//
//        Thread b = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Thread.sleep(5, 300000);
//                System.out.println("线程b执行了五分钟");
//                countDownLatch.countDown();
//            }
//        });

//        System.out.println("两个线程一起执行");
    }
}
