package com.yzm.线程状态;


import lombok.extern.slf4j.Slf4j;

/**
 * ##### 并发编程 高并发 线程状态
 *
 *      1、六种状态
 *          - New
 *          - Runnable
 *          - Waiting
 *          - Timed_Waiting
 *              - sleep(100)
 *          - Blocked
 *          - Terminated
 *
 *          - Thread内部定义的枚举
 *              - java.lang.Thread.State
 *
 * @author yzm
 * @date 2024/4/30
 */
@Slf4j
public class ThreadState {

    public static void main(String[] args) throws InterruptedException {

        // new
        newState();
        // runnable
        runnableState();
        // waiting
        waitingState();
        // timedWaiting
        timedWaitingState();
        // blocked
        blockedState();
        // terminated
        terminatedState();


    }

    private static void newState(){
        Thread t1 = new Thread(()->{
        });
        log.debug(t1.getState().name());
        t1.start();
    }

    private static void runnableState(){
        Thread t2 = new Thread(()->{
        });
        t2.start();
        log.debug(t2.getState().name());
    }

    private static void waitingState() throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();

        Thread t3 = new Thread(()->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();
        Thread.sleep(100);
        log.debug(t3.getState().name());
    }

    private static void timedWaitingState() throws InterruptedException {
        Thread t4 = new Thread(()->{
            synchronized (ThreadState.class){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t4.start();
        Thread.sleep(100);
        log.debug(t4.getState().name());
    }

    private static void blockedState() throws InterruptedException {
        Thread t5 = new Thread(()->{
            synchronized (ThreadState.class){
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t5.start();
        Thread.sleep(100);
        log.debug(t5.getState().name());
    }

    private static void terminatedState() throws InterruptedException {
        Thread t6 = new Thread(()->{

        });
        t6.start();
        Thread.sleep(100);
        log.debug(t6.getState().name());
    }

}
