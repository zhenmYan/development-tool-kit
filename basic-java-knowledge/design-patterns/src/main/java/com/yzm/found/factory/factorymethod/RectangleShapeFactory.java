package com.yzm.found.factory.factorymethod;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class RectangleShapeFactory implements ShapeFactory {

    @Override
    public RectangleShape create(){
        return new RectangleShape();
    }
}
