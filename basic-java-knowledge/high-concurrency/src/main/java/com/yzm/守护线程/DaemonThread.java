package com.yzm.守护线程;

import lombok.extern.slf4j.Slf4j;

/**
 * ##### 并发编程 守护线程
 *
 *      1、特点
 *          - 当进程中所有非守护线程都运行结束，守护线程则会强制结束，不管有没有执行完
 *
 *      2、使用方法
 *          - 调用setDaemon方法，入参为true
 *          - 注意需要在start方法前调用才会生效
 *
 *      3、应用
 *          - 如垃圾回收线程
 *
 *
 * @author yzm
 * @date 2024/5/2
 */
@Slf4j
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while (true){
                log.debug("线程t执行任务");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 需要在start方法前调用
        t.setDaemon(true);
        t.start();

        Thread.sleep(500);
        log.debug("主线程执行完毕");
    }
}
