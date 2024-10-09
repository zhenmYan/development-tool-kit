package java.com.yzm.leetcode.array;

/**
 * description:
 *
 * @author yzm
 * @date 2024/10/9
 */
public class Lc121MaxProfit {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            res = Math.max(prices[i]-min, res);
        }
        return res;
    }
}
