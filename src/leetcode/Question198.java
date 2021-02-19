package leetcode;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question198 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums.length == 0) return 0;

        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];

        for(int i = 2; i <= nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }

        return dp[nums.length];

    }
}
