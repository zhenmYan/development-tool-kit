package java.com.yzm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 *
 * @author yzm
 * @date 2024/10/8
 */
public class Lc1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
