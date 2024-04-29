package com.yzm.behavior.Iterator;

/**
 * ##### 设计模式 design patterns 迭代器模式
 *
 *      1、应用场景
 *          - 用于顺序访问集合对象的元素，不需要知道集合对象的底层表示
 *
 *      2、结构
 *          - 迭代器接口
 *          - 迭代器实现类
 *          - 集合接口
 *          - 集合实现类
 *
 * @author yzm
 * @date 2024/4/29
 */
public interface Iterator {
    public boolean hasNext();
    public Object next();
}
