package com.yzm.found.factory.simpleFactory;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
