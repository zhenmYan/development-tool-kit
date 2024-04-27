package com.yzm.found.factory.factorymethod;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class CircleShapeFactory implements ShapeFactory {

    @Override
    public CircleShape create(){
        return new CircleShape();
    }
}
