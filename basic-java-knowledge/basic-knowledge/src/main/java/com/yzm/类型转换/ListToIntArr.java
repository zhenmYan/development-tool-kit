package com.yzm.类型转换;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: yan
 * @description: list转化成int数组
 * @create: 2023-02-22 17:36
 **/

/**
 * tips::使用流式的maptoInt方法
 */
public class ListToIntArr {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
