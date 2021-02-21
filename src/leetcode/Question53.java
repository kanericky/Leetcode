package leetcode;

/**
 * @author kanericky
 * @version 1.0
 */


public class Question53 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int pre = 0;
        int maxSub = nums[0];

        for(int x : nums){
            pre = Math.max(pre+x, x);
            maxSub = Math.max(maxSub, pre);
        }
        return maxSub;
    }
}
