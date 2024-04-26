package com.yzm.found.factory.simplefactory;

/**
 * ##### 设计模式 design patterns 工厂模式
 *
 *      1、简单工厂
 *          - 工厂类可以根据传入类型创建多种对象
 *          - 不属于23种设计模式
 *          - 违背开闭原则
 *
 *      2、
 *
 * @author yzm
 * @date 2024/4/26
 */
public class SimpleShapeFactory {
    //使用 getShape 方法获取形状类型的对象
    public SimpleFactoryShape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new SimpleFactoryCircle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new SimpleFactoryRectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new SimpleFactorySquare();
        }
        return null;
    }

    public static void main(String[] args) {
        SimpleShapeFactory simpleShapeFactory = new SimpleShapeFactory();
        SimpleFactoryShape simpleFactoryShape1 = simpleShapeFactory.getShape("CIRCLE");
        simpleFactoryShape1.draw();
        SimpleFactoryShape simpleFactoryShape2 = simpleShapeFactory.getShape("RECTANGLE");
        simpleFactoryShape2.draw();
        SimpleFactoryShape simpleFactoryShape3 = simpleShapeFactory.getShape("SQUARE");
        simpleFactoryShape3.draw();
    }
}