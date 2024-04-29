package com.yzm.behavior.strategy;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/29
 */
public class StrategyA implements Strategy {
    @Override
    public void show() {
        System.out.println("促销活动A：买一送一");
    }
}
