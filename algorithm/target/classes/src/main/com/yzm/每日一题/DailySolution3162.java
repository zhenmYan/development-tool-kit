package com.yzm.每日一题;

/**
 * description:
 *
 * @author yzm
 * @date 2024/10/10
 */
public class DailySolution3162 {
    public static int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int res = 0;
        for(int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int temp = nums2[j]*k;
                if (nums2[j] != 0 && (nums1[i] % temp == 0) && (nums1[i] / temp >= 1)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,4,12};
        int[] nums2 = new int[]{2,4};
        numberOfPairs(nums1, nums2, 1);
    }
}
