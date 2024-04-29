package com.yzm.behavior.strategy;

/**
 * ##### 设计模式 design patterns 策略模式
 *
 *      1、应用场景
 *          - 在做种handler之间做选择
 *
 *      2、结构
 *          - 策略抽象类
 *          - 具体策略类
 *          - 环境类（Context）：供客户端使用
 *
 *      3、优缺点
 *          - 优点：利于扩展，减少if else代码
 *          - 缺点：
 *
 * @author yzm
 * @date 2024/4/29
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void show(){
        strategy.show();
    }

    public static void main(String[] args) {
        Strategy strategyA = new StrategyA();
        Context context = new Context(strategyA);
        context.show();
    }
}
