package com.yzm.found.factory.simpleFactory;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
