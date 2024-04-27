package com.yzm.found.factory.abstractfactory;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class BlackCircleFactory implements ShapeColorFactory {

    @Override
    public Shape createShape() {
        return new CircleShape();
    }

    @Override
    public Color createColor() {
        return new BlackColor();
    }
}
