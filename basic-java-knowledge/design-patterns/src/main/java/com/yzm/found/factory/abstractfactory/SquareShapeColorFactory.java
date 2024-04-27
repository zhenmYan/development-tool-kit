package com.yzm.found.factory.abstractfactory;

/**
 * description: 工厂方法
 *
 *      优点：符合开闭原则
 *      缺点：类太多了，系统复杂
 *
 * @author yzm
 * @date 2024/4/26
 */
public class SquareShapeColorFactory implements ShapeColorFactory {

    @Override
    public SquareShape create(){
        return new SquareShape();
    }

    public static void main(String[] args) {
        ShapeColorFactory factory1 = new BlackCircleFactory();
        factory1.create().draw();
        ShapeColorFactory factory2 = new RedRectangleFactory();
        factory2.create().draw();
        ShapeColorFactory factory3 = new SquareShapeColorFactory();
        factory3.create().draw();
    }
}
