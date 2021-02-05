import java.util.Arrays;

public class Question633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2));
    }

    public static boolean judgeSquareSum(int c) {
        if(c == 0) return true;

        int[] nums = new int[(int)Math.sqrt(c)+1];

        for(int i = 0 ; i <= Math.sqrt(c) ; i++) nums[i] = i;

        int leftIndex = 0, rightIndex = nums[nums.length-1];

        while(leftIndex <= nums.length-1 && rightIndex >= 0){

            if(nums[leftIndex] * nums[leftIndex] + nums[rightIndex] * nums[rightIndex] > c) rightIndex--;
            else if(nums[leftIndex] * nums[leftIndex] + nums[rightIndex] * nums[rightIndex] < c) leftIndex++;
            else return true;
        }
        return false;
    }

    public boolean judgeSquareSumWithoutArray(int c) {
        int left = 0;
        int right = (int) Math.floor(Math.sqrt(c));
        while(left <= right) {
            int temp = left * left +  right * right;
            if(temp > c) {
                right--;
            }else if(temp < c) {
                left++;
            }else {
                break;
            }
        }
        if(left <= right) {
            return true;
        }else {
            return false;
        }
    }

}
