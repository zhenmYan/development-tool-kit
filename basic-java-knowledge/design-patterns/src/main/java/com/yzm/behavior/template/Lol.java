package com.yzm.behavior.template;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/29
 */
public class Lol extends Game {
    @Override
    void initialize() {
        System.out.println("英雄联盟：已启动！");
    }

    @Override
    void startPlay() {
        System.out.println("英雄联盟：开始游戏");
    }

    @Override
    void endPlay() {
        System.out.println("英雄联盟：结束游戏");
    }
}
