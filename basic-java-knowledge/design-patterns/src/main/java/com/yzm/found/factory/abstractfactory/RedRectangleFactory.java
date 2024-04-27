package com.yzm.found.factory.abstractfactory;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class RedRectangleFactory implements ShapeColorFactory {

    @Override
    public Shape createShape() {
        return new RectangleShape();
    }

    @Override
    public Color createColor() {
        return new RedColor();
    }
}
