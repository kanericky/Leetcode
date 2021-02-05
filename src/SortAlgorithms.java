import java.util.Arrays;

public class SortAlgorithms {

    public static void main(String[] args) {
        int[] nums = new int[]{1,234,3,543,5,4,23,1,31};
        //quickSort(nums, 0 , nums.length);
        mergeSort(nums, 0 , nums.length, new int[nums.length]);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int left, int right){
        if(left + 1 >= right) return;

        int leftIndex = left, rightIndex = right - 1, key = nums[leftIndex];
        while(leftIndex < rightIndex){
            while(leftIndex < rightIndex && nums[rightIndex] >= key){
                rightIndex--;
            }
            nums[leftIndex] = nums[rightIndex];
            while(leftIndex < rightIndex && nums[leftIndex] <= key){
                leftIndex++;
            }
            nums[rightIndex] = nums[leftIndex];
        }
        nums[rightIndex] = key;
        quickSort(nums, left, leftIndex);
        quickSort(nums, leftIndex+1, right);
    }

    private static void mergeSort(int[] nums, int left, int right, int[] temp){
        if(left + 1 >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid, right, temp);

        int p = left, q = mid, i = left;

        while(p < mid || q < right){
            if(q >= right || (p < mid && nums[p] <= nums[q])) temp[i++] = nums[p++];
            else temp[i++] = nums[q++];
        }

        for(int a = left; a < right; a++) nums[a] = temp[a];


    }


}
