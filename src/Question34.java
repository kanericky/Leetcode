import java.util.Arrays;

public class Question34 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(Arrays.toString(searchRange(nums, 1)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};

        int leftIndex, rightIndex;


        leftIndex = getLowerBound(nums, target);
        rightIndex = getUpperBound(nums, target) - 1;

        if(leftIndex == nums.length || nums[leftIndex] != target)
            return new int[]{-1, -1};
        else
            return new int[]{leftIndex, rightIndex};
    }

    private static int getLowerBound(int[] nums, int target){
        int leftIndex = 0, rightIndex = nums.length, mid;

        while(leftIndex < rightIndex){
            mid = (leftIndex + rightIndex) / 2;
            if (nums[mid] < target)
                leftIndex = mid + 1;
            else
                rightIndex = mid;
        }
        return leftIndex;
    }

    private static int getUpperBound(int[] nums, int target){
        int leftIndex = 0, rightIndex = nums.length, mid;

        while(leftIndex < rightIndex){
            mid = (leftIndex + rightIndex) / 2;

            if (nums[mid] > target)
                rightIndex = mid;
            else
                leftIndex = mid + 1;
        }
        return leftIndex;
    }


}
