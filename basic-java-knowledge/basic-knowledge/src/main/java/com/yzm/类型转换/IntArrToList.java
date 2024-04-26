package com.yzm.类型转换;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: yan
 * @description: int数组转化成list
 * @create: 2023-02-22 17:31
 **/

/**
 * tips:使用stream流，注意要使用装箱方法，不然会报错
 */
public class IntArrToList {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<Integer> type1 = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(type1);
    }
}
