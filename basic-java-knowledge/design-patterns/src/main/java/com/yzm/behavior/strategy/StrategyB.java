package com.yzm.behavior.strategy;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/29
 */
public class StrategyB implements Strategy {
    @Override
    public void show() {
        System.out.println("促销活动B：返现50");
    }
}
