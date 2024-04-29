package com.yzm.structure.facade;

/**
 * ##### 设计模式 design patterns 外观模式 门面模式
 *
 *      1、应用场景
 *          - 隐藏系统的复杂性
 *
 *      2、特点
 *          - 迪米特原则的最佳应用模式
 *
 *      3、优缺点
 *          - 优点：屏蔽系统复杂性
 *          - 缺点：违背开闭原则
 *
 * @author yzm
 * @date 2024/4/29
 */
public class ShapeFacade {
    private Shape circle;
    private Shape rectangle;

    public ShapeFacade() {
        circle = new Circle();
        rectangle = new Rectangle();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }

    public static void main(String[] args) {
        ShapeFacade facade = new ShapeFacade();
        facade.drawCircle();
        facade.drawRectangle();
    }
}
