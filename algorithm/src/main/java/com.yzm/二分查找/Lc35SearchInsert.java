package com.yzm.二分查找;

/**
 * description:
 *
 * 难度：简单
 *
 *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 *  请必须使用时间复杂度为 O(log n) 的算法。
 *
 * @author yzm
 * @date 2025/2/24
 */
public class Lc35SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (target <= nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
