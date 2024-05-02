package com.yzm.中断;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * ##### 并发编程 中断
 *
 *          不可中断的意思是等待获取锁的时候不可中断，拿到锁之后可中断，
 *          没获取到锁的情况下，中断操作一直不会生效
 *
 *
 *          原因：
 *
 *          只是做了修改一个中断状态值为true，并没有显式声明抛出InterruptedException异常
 *
 *          等待状态（如sleep等待的时间范围内）interrupt()只设置标志位true，不抛异常
 *          非等待状态（如sleep等待结束）interrupt()设置标志位未false，抛异常
 *
 *
 *
 * @author 颜真明
 * @date 2024/3/19
 */
@Slf4j
public class InterruptTest {
    private static final Object o1 = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 打断sleep方法
//        interruptSleep();
        // 打断正常运行的线程
//        interruptRunThead();
        // 两阶段终止
//        twoPhaseTermination();
        // 打断park方法
        interruptPark();

    }

    /**
     * 中断 sleep 方法
     *
     *      sleep、wait、join等方法在被打断时，会抛出异常，并将打断标记置为false
     *
     */
    private static void interruptSleep() throws InterruptedException {
        Thread interruptSleepThread = new Thread(()->{
            try {
                log.debug("interruptSleepThread sleep...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        interruptSleepThread.start();
        Thread.sleep(1000);
        log.debug("interruptSleepThread 开始打断线程");
        interruptSleepThread.interrupt();
        // false
        log.debug("interruptSleepThread 打断标记位:{}", interruptSleepThread.isInterrupted());
    }

    /**
     * 中断正常运行的线程
     *
     *      不会被中断，仅仅设置了一个标志位为true而已
     */
    private static void interruptRunThead() throws InterruptedException {
        Thread interruptRunTheadThread = new Thread(()->{
            log.debug("interruptRunTheadThread开始运行");
            while (true){}
        });
        interruptRunTheadThread.start();
        Thread.sleep(1000);
        log.debug("interruptRunTheadThread 主线程开始打断");
        interruptRunTheadThread.interrupt();
        log.debug("interruptRunTheadThread 打断标志位 {}", interruptRunTheadThread.isInterrupted());
    }

    /**
     * 两阶段终止
     *
     *      优雅的终止线程
     *
     * @throws InterruptedException
     */
    private static void twoPhaseTermination() throws InterruptedException {
        Thread twoPhaseTerminationThread = new Thread(()->{
            while (true){
                // 执行业务逻辑
                log.debug("twoPhaseTermination 执行业务逻辑");
                if (Thread.currentThread().isInterrupted()) {
                    // 料理后事
                    log.debug("twoPhaseTermination 当前线程被打断，执行打断前相关事项，然后结束循环");
                    break;
                }
                try {
                    // 等待一段时间，防止CPU被当前线程打满
                    log.debug("twoPhaseTermination 进入等待状态，防止CPU被打满");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.debug("twoPhaseTermination 等待过程中被打断，将中断标志位重新置为true");
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
        twoPhaseTerminationThread.start();
        Thread.sleep(1000);
        twoPhaseTerminationThread.interrupt();
    }

    /**
     * 中断park方法
     *
     *      interrupt 可以打断一次park方法
     *      将中断标志位设置为true
     *
     *      park线程被中断后再执行park方法就无效了，需要调用interrupted将中断标记置为false
     *
     */
    private static void interruptPark() throws InterruptedException {
        Thread interruptParkThread = new Thread(()->{
            log.debug("interruptParkThread park...");
            LockSupport.park();
            log.debug("interruptParkThread unPark...");
            log.debug("interruptParkThread 中断状态:{}", Thread.currentThread().isInterrupted());

            // 这里无效
            LockSupport.park();
            log.debug("interruptParkThread park线程被中断后再执行park方法就无效了");

        });
        interruptParkThread.start();
        Thread.sleep(100);
        interruptParkThread.interrupt();
    }

    private static void temp(){
        //        Thread thread1 = new Thread(() -> {
//            System.out.println("t1 enter");
//            synchronized (o1) {
//                try {
//                    System.out.println("start lock t1");
//                    Thread.sleep(20000);
//                    System.out.println("end lock t1");
//                } catch (InterruptedException e) {
//                    System.out.println("t1 interruptedException");
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            System.out.println("t2 enter");
//            synchronized (o1) {
//                try {
//                    System.out.println("start lock t2");
//                    Thread.sleep(1000);
//                    System.out.println("end lock t2");
//                } catch (InterruptedException e) {
//                    System.out.println("t2 interruptedException");
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//
//        // 主线程休眠一下，让t1,t2线程百分百已经启动，避免线程交替导致测试结果混淆
//        Thread.sleep(1000);
//        // 中断t2线程的执行
//        thread1.interrupt();
//        thread2.interrupt();
//        System.out.println("t2 interrupt...");
    }

}

