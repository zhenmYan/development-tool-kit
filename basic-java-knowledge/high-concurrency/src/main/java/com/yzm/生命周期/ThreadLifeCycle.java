package com.yzm.生命周期;

import java.util.HashMap;

/**
 * @author yanzhenming
 * @date 2023/3/16  16:33
 */
public class ThreadLifeCycle {
    public static void main(String[] args) {
        Object object = new Object();
        HashMap<Integer, Integer> map = new HashMap<>();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                System.out.println("开始睡眠");
//                Thread.sleep(1000);
//                System.out.println("睡眠结束");
//                Thread thread = Thread.currentThread();
//                thread.wait(1000);
//                thread.notify();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
