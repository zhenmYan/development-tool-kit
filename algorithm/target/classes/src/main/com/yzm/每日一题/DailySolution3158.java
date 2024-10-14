package com.yzm.每日一题;


import java.util.HashSet;
import java.util.Set;

public class DailySolution3158{

    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> cnt = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            if (cnt.contains(num)) {
                res ^= num;
            } else {
                cnt.add(num);
            }
        }
        return res;
    }

}
