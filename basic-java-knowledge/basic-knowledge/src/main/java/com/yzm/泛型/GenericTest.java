package com.yzm.泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanzhenming
 * @date 2023/3/14  17:16
 */
public class GenericTest {

    public static void main(String[] args) {
        show("泛型方法");
        Node<Integer> node = new Node<>();
        List<Integer> list = new ArrayList<>();

        Integer[] arr = test();
        arr[0] = 1;
        arr[1] = 2;
    }

    /**
     * 泛型数组
     *
     * @param <T>
     * @return
     */
    public static <T> T[] test(){
        T[] arr = null;
        return arr;
    }


/**
     * 泛型类
     *
     * @param <T>
     */
    static class Node <T>{
        private T value;
        Node next;
        Node(){}
        Node(T value){
            this.value=value;
        }
    }

    /**
     * 泛型方法
     *
     * @param t
     * @param <T>
     */
    public static <T> void show(T t) {
        System.out.println(t);
    }
}
