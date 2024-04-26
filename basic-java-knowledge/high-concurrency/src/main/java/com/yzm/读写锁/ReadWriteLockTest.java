package com.yzm.读写锁;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * description:
 *
 * @author 颜真明
 * @date 2024/3/22  0:58
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();


    }

}
