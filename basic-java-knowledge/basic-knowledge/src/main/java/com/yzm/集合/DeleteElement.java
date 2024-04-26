package com.yzm.集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 遍历集合过程中删除元素
 * 普通方法会有并发修改异常，使用迭代器可以解决
 *
 * @author yanzhenming
 * @date 2023/3/14  17:37
 */
public class DeleteElement {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("b");

//        for(int i = 0; i < list.size(); i++) {
////            if ("b".equals(list.get(i))){
////                System.out.println(i);
////            }
//            list.remove(i);
//
//
//        }


//         流式处理，遍历过程中删除元素会有异常
//        list.stream().map(s -> {
//            if ("a".equals(s)) {
//                list.add("a");
//            }
//            return list;
//        }).collect(Collectors.toList()); // Exception in thread "main" java.util.ConcurrentModificationException
//
//
        // for循环也会有异常
//        for (String s : list) {
//            if ("a".equals(s)) {
//                list.remove(s);  // Exception in thread "main" java.util.ConcurrentModificationException
//            }
//        }


        // 使用迭代器，可以解决并发问题
//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            if ("a".equals(iterator.next())) {
//                iterator.remove();
//            }
//        }

        
//        System.out.println(list);
    }

}
