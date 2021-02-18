package leetcode;

public class Question540 {
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,3};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int leftIndex = 0, rightIndex = nums.length - 1, midIndex = -1;

        if(nums.length == 1) return nums[0];

        while(leftIndex < rightIndex){
            midIndex = (leftIndex + rightIndex ) / 2;

            //MidIndex is an even number...
            if(midIndex % 2 == 0){
                if(nums[midIndex] == nums[midIndex+1]){
                    leftIndex = midIndex + 1;
                }else{
                    rightIndex = midIndex;
                }
            }else{ // MidIndex is an odd number...
                if(nums[midIndex] == nums[midIndex-1]){
                    leftIndex = midIndex + 1;
                }else{
                    rightIndex = midIndex;
                }
            }
        }


        return nums[rightIndex];
    }

}
