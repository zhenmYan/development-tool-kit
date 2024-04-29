package com.yzm.behavior.observer;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/29
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
