package com.yzm.found.factory.simpleFactory;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
