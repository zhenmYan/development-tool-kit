package com.yzm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2025/2/21
 */
public class Solution {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(perfectNumber(10000));
        System.out.println(Arrays.toString(list.toArray()));

    }

    private static int perfectNumber(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            int t = i/2;
            for (int j = 1; j <= t; j++) {
                if (i%j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                count++;
                list.add(i);
            }
        }
        return count;
    }
}
