package leetcode;

import java.util.Arrays;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question413 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;

        int n = nums.length;
        int[] dp = new int[n+1];

        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
                dp[i] = dp[i-1] + 1;
        }

        return Arrays.stream(dp).sum();
    }
}
