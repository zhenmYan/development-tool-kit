package com.yzm.锁升级.偏向锁;


/**
 * description:
 *
 * @author 颜真明
 * @date 2024/2/25  17:31
 */
public class BiasedLock {

    public static void main(String[] args) {
        Object o = new Object();
        new Thread(()->{
           synchronized (o){
//               System.out.println(ClassLayout.parseInstance(o).toPrintable());
           }
        },"t").start();

    }
}
