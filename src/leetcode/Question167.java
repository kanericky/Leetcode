package leetcode;

import java.util.Arrays;

public class Question167 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},10)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0, rightIndex = numbers.length-1;

        while (leftIndex < rightIndex){
            int sum = numbers[leftIndex] + numbers[rightIndex];
            if(sum == target) break;;
            if(sum > target) rightIndex--;
            else leftIndex++;
        }
        return new int[]{leftIndex+1, rightIndex+1};
    }
}
