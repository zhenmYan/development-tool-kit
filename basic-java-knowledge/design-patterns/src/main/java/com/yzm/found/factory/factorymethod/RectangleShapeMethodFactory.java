package com.yzm.found.factory.factorymethod;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class RectangleShapeMethodFactory implements ShapeMethodFactory {

    @Override
    public FactoryMethodRectangle create(){
        return new FactoryMethodRectangle();
    }
}
