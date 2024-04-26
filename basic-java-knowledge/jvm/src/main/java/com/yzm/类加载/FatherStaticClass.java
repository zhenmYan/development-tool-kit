package com.yzm.类加载;

/**
 * description:
 *
 * @author 颜真明
 * @date 2024/4/1  10:13
 */
public class FatherStaticClass {
    FatherStaticClass(){
        System.out.println("父类构造方法");
    }
    public void test(){
        System.out.println("父类非静态方法");
    }
    public static void testStatic(){
        System.out.println("父类静态方法");
    }
    static {
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类非静态代码块");
    }
}
