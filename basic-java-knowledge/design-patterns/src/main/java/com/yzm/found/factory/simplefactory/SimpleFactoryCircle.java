package com.yzm.found.factory.simplefactory;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class SimpleFactoryCircle implements SimpleFactoryShape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
