package com.yzm.structure.decorator;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/28
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
