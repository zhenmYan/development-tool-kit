package com.yzm.found.factory.abstractfactory;


/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class RectangleShape implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
