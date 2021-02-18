package leetcode;

import javax.xml.stream.events.StartDocument;
import java.util.Random;

/**
 * @author kanericky
 * @see <a href = "kth-largest-element-in-an-array">https://leetcode-cn.com/problems/kth-largest-element-in-an-array</a>
 */


public class Question215 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0) return -1;

        shuffle(nums);

        int left = 0, right = nums.length - 1, target = nums.length - k;

        while(left < right){
            int mid = quickSelect(nums, left, right);

            if(mid == target) return nums[mid];

            if(mid < target) left = mid + 1 ;
            else right = mid - 1;
        }

        return nums[left];
    }

    private static int quickSelect(int[] nums, int left, int right){
        int leftIndex = left + 1;
        int rightIndex = right;

        while(true){
            while(leftIndex < right && nums[leftIndex] <= nums[left]) leftIndex++;
            while(left < rightIndex && nums[rightIndex] >= nums[left]) rightIndex--;
            if(leftIndex >= rightIndex){
                break;
            }
            swap(nums, leftIndex, rightIndex);
        }
        swap(nums, left, rightIndex);
        return rightIndex;
    }

    public static <T> void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T> void shuffle(int[] arr) {
        Random rand = new Random();
        int length = arr.length;
        for ( int i = length; i > 0; i-- ){
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }
    }

}
