package com.yzm.leetcode.array;

/**
 * description:
 *
 * @author yzm
 * @date 2024/10/8
 */
public class Lc31NextPermutation {
    public static void nextPermutation(int[] nums) {
        // 倒序找到降序点
        int reversePoint = -1;
        int lowPoint = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                reversePoint = i - 1;
                break;
            }
        }
        if (reversePoint == -1) {
            // 翻转数组
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // 倒序找到第一个比降序点大的数
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[reversePoint]) {
                lowPoint = i;
                break;
            }
        }
        // 交换这两个数
        swap(nums, reversePoint, lowPoint);
        // 将降序点后的数组逆序
        reverse(nums, reversePoint + 1, nums.length - 1);
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
