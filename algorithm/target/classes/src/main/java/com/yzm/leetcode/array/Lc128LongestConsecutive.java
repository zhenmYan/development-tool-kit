package java.com.yzm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * description:
 *
 * @author yzm
 * @date 2024/10/9
 */
public class Lc128LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            int temp = 0;
            if (set.contains(num-1)) {
                continue;
            }
            while (set.contains(num)) {
                num++;
                temp++;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
