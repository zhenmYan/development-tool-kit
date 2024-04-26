package com.yzm.集合.ArrayList安全问题;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/14  18:28
 */
public class ArrayListThreadSafeTest {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        /**
         * 1、问题
         *      java.util.ConcurrentModificationException
         *
         * 2、原因
         *      foreach写法是对实际的Iterable、hasNext、next方法的简写
         *      调用list.remove会修改modCount的值
         *      但在ArrayList返回的迭代器expectedModCount不会修改
         *      此时会比较两个值是否相等，不相等则抛出异常
         *
         * 3、解决方法
         *      使用迭代器，然后用迭代器进行删除
         *
         */
//        for (String s: list1) {
//            list1.remove(s);
//        }

        // 普通的for循环则不会出现ConcurrentModificationException
//        for(int i = 0; i < list1.size(); i++){
//            list1.remove(i);
//        }
//        for(int i = 0; i < list1.size(); i++){
//            String s = list1.get(i);
//            list1.remove(s);
//        }
        /**
         * 1、问题
         *      无法将所有数据全部删除
         *
         * 2、原因
         *      删除元素后，会调用System.arraycopy复制一个数组
         *      将数据迁移后会导致相对位置发生偏移
         *
         * 3、解决方法
         *      从尾部删除
         */
//        for(int i = 0; i < list1.size(); i++){
//            String s = list1.get(i);
//            list1.remove(s);
//        }
        /**
         * 1、问题
         *      java.lang.IndexOutOfBoundsException
         *
         * 2、跟上面原因一样
         *      删除元素后，会调用System.arraycopy复制一个数组
         *      将数据迁移后会导致相对位置发生偏移
         *
         * 3、解决办法
         *      使用迭代器
         *      从尾部删除
         */
//        for(int i = 0; i < 5; i++){
//            list1.remove(i);
//        }
        // 可以从尾部删除
//        for(int i = 4; i>=0 ; i--){
//            list1.remove(i);
//        }

        for(int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }
    }
}
