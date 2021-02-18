package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question046 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(nums, 0, ans);
        return ans;
    }

    private static void backTracking(int[] nums, int level, List<List<Integer>> ans){
        //边界情况，完成交换，放入结果
        if(level == nums.length - 1){
            List<Integer> tempList = new ArrayList<>();
            for(int i:nums) tempList.add(i);
            ans.add(tempList);
            return;
        }

        for(int i = level; i < nums.length; i++){
            //交换
            swap(nums, level, i);
            //回溯
            backTracking(nums,level+1,ans);
            //还原
            swap(nums, level, i);
        }
    }

    private static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
