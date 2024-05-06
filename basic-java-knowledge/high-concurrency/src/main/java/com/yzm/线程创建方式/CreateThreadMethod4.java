package com.yzm.线程创建方式;

import java.util.concurrent.*;

/**
 * 创建线程的方式四：线程池
 *
 * @author: yan
 * @description:
 * @create: 2023-02-21 10:55
 **/
public class CreateThreadMethod4 {



    public static void main(String[] args) {

        /**
         * 通过Executors创建，可以创建四种基本类型
         * 1、单线程线程池
         *      - 可以避免重复创建线程
         * 2、定长线程池
         *      - 只有核心线程
         *      - 控制线程最大并发数
         * 3、可缓存线程池
         *      - 无核心线程，非核心线程数量无限
         *      - 执行大量、耗时少的任务
         * 4、定时线程池
         *      - 核心线程数量固定，非核心线程数量无限
         *      - 非核心会定时回收
         *      - 执行定时或周期性的任务
         *
         */
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService4 = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        for (int i = 0; i < 5; i++) {
            executorService1.execute(runnable1);
            executorService2.execute(runnable1);
            executorService3.execute(runnable1);
            executorService4.execute(runnable1);
        }


        /**
         * 手动创建线程池
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("手动创建线程池" + Thread.currentThread().getName());
            }
        };
        for (int i = 0; i< 10; i++) {
            threadPoolExecutor.execute(runnable2);
        }
        ExecutorService executorService = new ThreadPoolExecutor(2, 10, 1000L,
                TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(1000));

        executorService.submit(()->{
            new Thread(()->{
                System.out.println("111");
            });
        }
        );


    }



}
