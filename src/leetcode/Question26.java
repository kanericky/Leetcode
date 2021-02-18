package leetcode;

import java.util.Arrays;

/**
 * 26. 删除排序数组中的重复项
 * 难度 简单
 *
 * AUTHOR: RUIQI ZHANG
 * DATE 29/10/2020
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */


public class Question26 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {

        if(nums.length == 1){
            return nums.length;
        }

        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] != nums[i+1]){
                nums = Arrays.copyOfRange(nums, i, nums.length);
            }
        }
        

        return nums.length;
    }
}
