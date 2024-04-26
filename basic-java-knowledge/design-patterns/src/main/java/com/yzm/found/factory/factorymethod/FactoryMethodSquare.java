package com.yzm.found.factory.factorymethod;


/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class FactoryMethodSquare implements FactoryMethodShape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
