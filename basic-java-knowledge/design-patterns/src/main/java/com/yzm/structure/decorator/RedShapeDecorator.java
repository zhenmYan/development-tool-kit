package com.yzm.structure.decorator;

/**
 * ##### 设计模式 design patterns 装饰器代理
 *
 *      1、应用场景
 *          - 扩展类的功能
 *
 *      2、特点
 *          - 可以替代继承
 *
 *      3、典型案例
 *          - MyBatis的CachingExecutor
 *              - 在开启缓存时，创建CachingExecutor，其他类型的Executor作为构造函数的入参
 *              - 其中的方法会对Executor的原方法做一个增强，增强主要是缓存方面的处理
 *
 * @author yzm
 * @date 2024/4/28
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }

    public static void main(String[] args) {

        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}