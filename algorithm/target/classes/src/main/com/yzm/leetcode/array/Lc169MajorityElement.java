package com.yzm.leetcode.array;

/**
 * description:
 *
 * @author yzm
 * @date 2024/10/14
 */
public class Lc169MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]) {
                count++;
            } else if (count == 0){
                res = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

}
