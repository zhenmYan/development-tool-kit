package com.yzm.线程状态;


/**
 * ##### 并发编程 高并发 线程状态
 *
 *      1、六种状态
 *          - New
 *          - Runnable
 *          - Waiting
 *          - Time_Waiting
 *              - sleep(100)
 *          - Blocked
 *          - Terminated
 *
 * @author yzm
 * @date 2024/4/30
 */
public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("执行run方法");
            }
        };

        Thread t1 = new Thread(r1);
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        t1.join();
        System.out.println(t1.getState());
    }
}
