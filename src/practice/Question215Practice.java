package practice;

/**
 * @author kanericky
 */
public class Question215Practice {
    public static void main(String[] args) {

    }

    public static int findKthLargest(int[] nums, int k){
        if(nums == null || nums.length == 0) return -1;

        //SHUFFLE nums

        int left = 0, right = nums.length - 1, targetIndex = nums.length - k;

        while(left < right){
            int mid = quickSelect(nums, left, right);

            if(mid == targetIndex) return nums[mid];
            if(mid < targetIndex) left = mid + 1;
            else right = mid - 1;
        }

        return nums[left];
    }

    private static int quickSelect(int[] nums, int left, int right) {
        int leftIndex = left + 1, rightIndex = right;

        while(true){
            while(leftIndex <= right && nums[leftIndex] <= nums[left]) leftIndex++;
            while(rightIndex >= leftIndex && nums[rightIndex] >= nums[left]) rightIndex--;
            if(leftIndex >= rightIndex) break;
            swap(nums, leftIndex, rightIndex);
        }
        swap(nums, left, rightIndex);
        return rightIndex;
    }

    private static void swap(int[] nums, int leftIndex, int rightIndex) {
        int temp = nums[leftIndex];
        nums[leftIndex] = nums[rightIndex];
        nums[rightIndex]  = temp;
    }
}
