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

        //shuffle避免极端情况（第数0位为最大数字）
        shuffle(nums);

        int left = 0, right = nums.length - 1, target = nums.length - k;

        while(left < right){
            //分治想法，取中位数
            int mid = quickSelect(nums, left, right);

            //如果中位数的位置达到第"k"大个，则直接返回目标
            if(mid == target) return nums[mid];
            //根据mid和target的关系进行二分，只需对需要的部分进行排序
            if(mid < target) left = mid + 1 ;
            else right = mid - 1;
        }

        return nums[left];
    }

    private static int quickSelect(int[] nums, int left, int right){
        //leftIndex = left + 1的原因是将left指向的int设置为对比项
        int leftIndex = left + 1;
        int rightIndex = right;

        //经过该循环后，找到nums[left]应在的位置
        while(true){
            //每次确保排序一个（即nums[left]）返回排序后nums[left]应在的位置
            while(leftIndex < right && nums[leftIndex] <= nums[left]) leftIndex++;
            while(left < rightIndex && nums[rightIndex] >= nums[left]) rightIndex--;
            if(leftIndex >= rightIndex) break;
            swap(nums, leftIndex, rightIndex);
        }
        //将nums[left]放入正确的位置
        swap(nums, left, rightIndex);
        //返回该位置
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

    public static int findKthLargestPractice(int[] nums, int k){
        if(nums == null || nums.length == 0) return -1;

        shuffle(nums);

        int left = 0, right = nums.length -1, target = nums.length - k;

        while(left < right){
            int mid = quickSelectPractice(nums, left, right);
            if(mid == target) return nums[mid];
            if(mid < target) left = mid + 1;
            else right = mid - 1;
        }

        return nums[left];
    }

    private static int quickSelectPractice(int[] nums, int left, int right) {
        int leftIndex = left + 1, rightIndex = right;
        while(true){
            while(leftIndex < right && nums[leftIndex] <= nums[left]) leftIndex++;
            while(left < rightIndex && nums[rightIndex] >= nums[left]) rightIndex--;
            if(leftIndex >= rightIndex) break;
            swap(nums, leftIndex, rightIndex);
        }
        swap(nums, left, rightIndex);
        return rightIndex;
    }

}
