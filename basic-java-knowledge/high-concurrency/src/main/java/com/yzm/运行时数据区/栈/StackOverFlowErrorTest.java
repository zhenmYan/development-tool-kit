package com.yzm.运行时数据区.栈;

/**
 * description:
 *
 *  触发StackOverflowError场景
 *
 *      递归调用方法
 *
 * @author 颜真明
 * @date 2024/3/22  21:22
 */
public class StackOverFlowErrorTest {

    public static void main(String[] args) {
//        StringBuilder s = new StringBuilder();
        while (true) {
            method();
//            s.append("1");
        }
    }
    static void method(){
        method();
    }
}
