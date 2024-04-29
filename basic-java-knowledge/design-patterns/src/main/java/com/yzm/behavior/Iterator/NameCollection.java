package com.yzm.behavior.Iterator;

/**
 * ##### 设计模式 design patterns 迭代器模式
 *      1、应用场景
 *          - 用于顺序访问集合对象的元素，不需要知道集合对象的底层表示
 *      2、结构
 *          - 迭代器接口
 *          - 迭代器实现类
 *          - 集合接口
 *          - 集合实现类
 *
 * @author yzm
 * @date 2024/4/29
 */
public class NameCollection implements Collection {

    public String[] names = {"Robert" , "John" ,"Julie" , "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }

    public static void main(String[] args) {
        NameCollection namesRepository = new NameCollection();

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}
