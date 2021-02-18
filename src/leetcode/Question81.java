package leetcode;

public class Question81 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,6,0,0,1,2};
        System.out.println(search(nums, 6));
    }

    public static boolean search(int[] nums, int target) {
        int leftIndex = 0, rightIndex = nums.length - 1, mid;

        while(leftIndex <= rightIndex){

            mid = (leftIndex + rightIndex) / 2;

            if(nums[mid] == target)
                return true;

            if (nums[leftIndex] == nums[mid])
                leftIndex++;
            else if (nums[mid] <= nums[rightIndex]){
                if(target > nums[mid] && target <= nums[rightIndex])
                    leftIndex = mid + 1;
                else
                    rightIndex = mid - 1;
            }else{
                if(target >= nums[leftIndex] && target < nums[mid])
                    rightIndex = mid - 1;
                else
                    leftIndex = mid + 1;
            }
        }

        return false;

    }

}
