import java.util.Arrays;

public class SortAlgorithms {

    public static void main(String[] args) {
        int[] nums = new int[]{1,234,3,543,5,4,23,1,31,0};
        //quickSort(nums, 0 , nums.length);
        //mergeSort(nums, 0 , nums.length, new int[nums.length]);
        //insertSort(nums);
        //bubbleSort(nums);
        //selectSort(nums);
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

    private static void mergeSort(int[] nums, int leftIndex, int rightIndex, int[] temp){
        if(leftIndex + 1 >= rightIndex) return; // 分解完成，分解为单位为1/2的数组。 leftIndex+1是为了考虑奇数数组的情况

        int midIndex = leftIndex + (rightIndex - leftIndex) / 2; // 获取MidIndex

        mergeSort(nums, leftIndex, midIndex, temp); //分解左半边
        mergeSort(nums, midIndex, rightIndex, temp); // 分解右半边

        /**
         * Merge the left / right arrays...
         * @variable array01Index:
         * @variable array02Index:
         * @variable mergeArrayIndex;
         */
        int array01Index = leftIndex, array02Index = midIndex, mergeArrayIndex = leftIndex;

        /**
         * @statement array01Index < midIndex: 在分解后第一个"数组"内
         * @statement array02Index < rightIndex: 在分解后第二个"数组"内
         */
        while(array01Index < midIndex || array02Index < rightIndex){
            /**
             * 比较两个分解后的"数组"
             */
            if(array02Index >= rightIndex || (array01Index < midIndex && nums[array01Index] <= nums[array02Index]))
                temp[mergeArrayIndex++] = nums[array01Index++];
            else
                temp[mergeArrayIndex++] = nums[array02Index++];
        }

        for(int a = leftIndex; a < rightIndex; a++) nums[a] = temp[a];
    }

    private static void insertSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j > 0 && nums[j] < nums[j-1]; j--){
                    swap(nums, j, j-1);
            }
        }
    }

    private static void bubbleSort(int[] nums){
        boolean isSorted;
        for(int i = 1; i < nums.length; i++){
            isSorted = false;
            for(int j = 1; j < nums.length - i + 1; j++){
                if(nums[j] < nums[j-1]){
                    swap(nums, j, j-1);
                    isSorted = true;
                }
            }
            if(!isSorted) break;
        }
    }

    private static void selectSort(int[] nums){
        for(int i = 0; i < nums.length-1; i++){
            int minIndex = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private static void swap(int[] nums, int element1, int element2){
        var temp = nums[element1];
        nums[element1] = nums[element2];
        nums[element2] = temp;
    }

}
