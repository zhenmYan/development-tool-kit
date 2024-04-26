package com.yzm.found.factory.factorymethod;


/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class FactoryMethodCircle implements FactoryMethodShape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
