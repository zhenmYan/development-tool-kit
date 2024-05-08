package com.yzm.自定义锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description:
 *
 * @author yzm
 * @date 2024/5/8
 */
public class YzmLock implements Lock{

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
    }

    // 独占锁
    class AbstractQueuedSynchronizerImpl extends AbstractQueuedSynchronizer {

        public Condition newCondition() {
            return new ConditionObject(){};
        }

        @Override
        protected boolean tryAcquire(int arg){
            if (compareAndSetState(0,1)){
                // 加锁成功，设置owner为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg){
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 是否持有独占锁
        @Override
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }
    }

    AbstractQueuedSynchronizerImpl sync = new AbstractQueuedSynchronizerImpl();


    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
