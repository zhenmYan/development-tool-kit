package com.yzm.structure.decorator;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/28
 */
public  abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(){
        decoratedShape.draw();
    }
}