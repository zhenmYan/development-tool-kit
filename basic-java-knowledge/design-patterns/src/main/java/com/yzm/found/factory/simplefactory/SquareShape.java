package com.yzm.found.factory.simplefactory;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class SquareShape implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
