package com.yzm.behavior.template;

/**
 * ##### 设计模式 design patterns 模板方法模式
 *
 *
 *
 * @author yzm
 * @date 2024/4/29
 */
public class Client {

    public static void main(String[] args) {
        Game game = new Lol();
        game.play();
        System.out.println();
        game = new F399();
        game.play();
    }

}
