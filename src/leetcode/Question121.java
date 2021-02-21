package leetcode;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question121 {
    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }

    //推导状态转移方程：
    //
    //dp[i][0]：规定了今天不持股，有以下两种情况：
    //
    //昨天不持股，今天什么都不做；
    //昨天持股，今天卖出股票（现金数增加），
    //dp[i][1]：规定了今天持股，有以下两种情况：
    //
    //昨天持股，今天什么都不做（现金数与昨天一样）；
    //昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）
    //

    public static int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int m = prices.length;

        int[][] dp = new int[m][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1; i < m; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }

        return dp[m-1][0];
    }
}
