package leetcode;

import java.util.Arrays;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question746 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] nums1 = new int[]{0,0,1,1};
        System.out.println(minCostClimbingStairs(nums));
    }


    public static int minCostClimbingStairs(int[] cost) {
        int m = cost.length;
        int[] dp = new int[m+1];

        if(m == 0) return 0;

        dp[0] = dp[1] = 0;

        for(int i = 2; i <= m; i++)
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);

        return dp[m];

    }

}
