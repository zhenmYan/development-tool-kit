package com.yzm.found.factory.factorymethod;

/**
 * description: 工厂方法
 *
 *      优点：符合开闭原则
 *      缺点：类太多了，系统复杂
 *
 * @author yzm
 * @date 2024/4/26
 */
public class SquareShapeFactory implements ShapeFactory {

    @Override
    public SquareShape create(){
        return new SquareShape();
    }

    public static void main(String[] args) {
        ShapeFactory factory1 = new CircleShapeFactory();
        factory1.create().draw();
        ShapeFactory factory2 = new RectangleShapeFactory();
        factory2.create().draw();
        ShapeFactory factory3 = new SquareShapeFactory();
        factory3.create().draw();
    }
}
