package com.yzm.found.factory.simplefactory;

/**
 * ##### 设计模式 design patterns 工厂模式
 *
 *      1、简单工厂
 *          - 工厂类可以根据传入类型创建多种对象
 *          - 不属于23种设计模式
 *          - 违背开闭原则
 *
 *      2、工厂方法
 *          - 组成部分
 *              - 产品接口
 *              - 产品实现类
 *              - 抽象工厂类
 *              - 抽象工厂类的实现类
 *          - 每个工厂只创建一种对象
 *          - 优缺点
 *              - 优：符合开闭原则
 *              - 缺：类太多了，增加系统复杂性
 *
 *      3、抽象工厂
 *          - 组成部分
 *              - 产品接口
 *              - 产品实现类
 *              - 抽象工厂类
 *              - 抽象工厂类的实现类
 *          - 与工厂方法的不同是抽象工厂可以生成多种对象，组成一个产品集
 *
 * @author yzm
 * @date 2024/4/26
 */
public class ShapeFactory {
    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new CircleShape();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RectangleShape();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new SquareShape();
        }
        return null;
    }

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
    }
}
