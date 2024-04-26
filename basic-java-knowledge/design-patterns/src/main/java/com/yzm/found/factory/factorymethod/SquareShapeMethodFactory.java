package com.yzm.found.factory.factorymethod;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/26
 */
public class SquareShapeMethodFactory implements ShapeMethodFactory{

    @Override
    public FactoryMethodSquare create(){
        return new FactoryMethodSquare();
    }

    public static void main(String[] args) {
        CircleShapeMethodFactory factory1 = new CircleShapeMethodFactory();
        factory1.create().draw();
        RectangleShapeMethodFactory factory2 = new RectangleShapeMethodFactory();
        factory2.create().draw();
        SquareShapeMethodFactory factory3 = new SquareShapeMethodFactory();
        factory3.create().draw();
    }
}
