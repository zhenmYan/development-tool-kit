package com.yzm.手写同步器;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/10  10:39
 */
public class AQSImpl extends AbstractQueuedSynchronizer {

    private static volatile int stock = 10;
    public static void buy() {
        try {
            // 模拟购买的耗时
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (stock > 0) {
            System.out.println("购买成功，剩余库存为："+ stock);
            stock--;
        } else {
            System.out.println("购买失败，库存不足，剩余库存为："+ stock);
        }
    }
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            new Thread(()->{
                buy();
            }).start();
        }
    }

    public void tryLock(){
        super.setState(1);
        super.acquire(getState());
    }

    public void release(){

    }

}
