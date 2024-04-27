package com.yzm.found.factory.abstractfactory;


/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class CircleShape implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
