package com.yzm.集合;

import java.util.HashMap;
import java.util.HashSet;

/**
 *      ***** HashSet
 *
 *            1、是使用HashMap进行存储
 *                  key为存储的值
 *                  value为新创建的对象，因为HashMap只能存一对空键值对，所以每次创建都会新建一个对象
 *
 *            2、因为是用的HashMap，所以不会覆盖值
 *
 * @author 颜真明
 * @date 2024/3/16  14:00
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(1);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
    }

}
