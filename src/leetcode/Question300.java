package leetcode;

import java.util.Arrays;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question300 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int m = nums.length;
        if(m == 0) return 0;

        int[] dp = new int[m + 1];
        Arrays.fill(dp, 1);
        int max = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}
