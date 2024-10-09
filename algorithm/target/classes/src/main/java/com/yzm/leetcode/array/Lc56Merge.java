package java.com.yzm.leetcode.array;

import java.util.Arrays;

/**
 * description:
 *
 * @author yzm
 * @date 2024/10/9
 */
public class Lc56Merge {
    public static int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int index = 0;
        // 遍历
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[index][1]) {
                intervals[++index] = intervals[i];
            } else {
                intervals[index][1] = Math.max(intervals[i][1],intervals[index][1]);
            }
        }
        return Arrays.copyOf(intervals, index);
    }
}
