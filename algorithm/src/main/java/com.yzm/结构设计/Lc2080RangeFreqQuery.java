package com.yzm.结构设计;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * description:
 *
 *      请你设计一个数据结构，它能求出给定子数组内一个给定值的频率
 *
 *      子数组中一个值的频率指的是这个子数组中这个值的出现次数
 *
 *      请你实现 RangeFreqQuery 类：
 *
 *          - RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例
 *          - int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的频率
 *
 *      一个子数组指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内的中间一段连续元素

 * @author yzm
 * @date 2025/2/18
 */
public class Lc2080RangeFreqQuery {

    // 数值为键，出现下标数组为值的哈希表
    private Map<Integer, List<Integer>> occurrence;

    public Lc2080RangeFreqQuery(int[] arr) {
        occurrence = new HashMap<>();
        // 顺序遍历数组初始化哈希表
        for (int i = 0; i < arr.length; ++i) {
            occurrence.putIfAbsent(arr[i], new ArrayList<>());
            occurrence.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int value) {
        // 查找对应的出现下标数组，不存在则为空
        List<Integer> pos = occurrence.getOrDefault(value, new ArrayList<>());
        // 两次二分查找计算子数组内出现次数
        int l = lowerBound(pos, left);
        int r = upperBound(pos, right);
        return r - l;
    }

    private int lowerBound(List<Integer> pos, int target) {
        int low = 0, high = pos.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pos.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int upperBound(List<Integer> pos, int target) {
        int low = 0, high = pos.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pos.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}
