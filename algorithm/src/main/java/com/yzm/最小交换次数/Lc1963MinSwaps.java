package com.yzm.最小交换次数;

/**
 * description:
 *
 * 给你一个字符串 s ，下标从 0 开始 ，且长度为偶数 n 。字符串 恰好 由 n / 2 个开括号 '[' 和 n / 2 个闭括号 ']' 组成。
 *
 * 只有能满足下述所有条件的字符串才能称为 平衡字符串 ：
 *
 *      字符串是一个空字符串，或者
 *      字符串可以记作 AB ，其中 A 和 B 都是 平衡字符串 ，或者
 *      字符串可以写成 [C] ，其中 C 是一个 平衡字符串 。
 *      你可以交换 任意 两个下标所对应的括号 任意 次数。
 *
 * 返回使 s 变成 平衡字符串 所需要的 最小 交换次数。
 *
 * @author yzm
 * @date 2025/3/17
 */
public class Lc1963MinSwaps {
    public int minSwaps(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                cnt ++;
            } else if (ch == ']' && cnt > 0) {
                cnt --;
            }
        }
        return (cnt+1)/2;
    }
}
