package com.yzm.类加载;

/**
 * description:
 *
 *      规律：
 *          父类>子类、静态>非静态、代码块>构造方法、静态与非静态方法需要手动调用
 *
 *      执行顺序：
 *          父类静态代码块>子类静态代码块>父类非静态代码块>父类构造方法>子类非静态代码块>子类构造方法
 *
 *      原理：
 *          静态代码块在类加载的初始化阶段执行
 *          非静态代码块是用来初始化类实例信息的，当new关键字创建一个对象的时候，就会被执行
 *
 * @author 颜真明
 * @date 2024/4/1  10:14
 */
public class ChildStaticClass extends FatherStaticClass {
    ChildStaticClass(){
        System.out.println("子类构造方法");
    }
    static {
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类非静态代码块");
    }
    public static void main(String[] args) {
        ChildStaticClass c = new ChildStaticClass();
    }
}
