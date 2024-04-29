package com.yzm.structure.facade;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/29
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
