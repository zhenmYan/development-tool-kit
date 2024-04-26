package com.yzm.found.factory.factorymethod;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class CircleShapeMethodFactory implements ShapeMethodFactory{

    @Override
    public FactoryMethodCircle create(){
        return new FactoryMethodCircle();
    }
}
