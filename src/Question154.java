public class Question154 {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 3, 1} ;
        System.out.println(findMin(nums));
    }

    public static int findMin153(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int leftIndex = 0, rightIndex = nums.length - 1, mid;
        int smallest = nums[0];

        while(leftIndex <= rightIndex){
            mid = (leftIndex + rightIndex) / 2;
            if(nums[mid] == smallest ){
                leftIndex++;
            } else if(nums[mid] < smallest){
                smallest = nums[mid];
                rightIndex = mid ;
            } else{ // nums[mid] > nums[lefIndex]
                leftIndex = mid + 1;
            }
        }
        return  smallest;
    }

    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        if(nums.length == 2) return Math.min(nums[0], nums[1]);


        int leftIndex = 0, rightIndex = nums.length - 1, mid;
        int smallest = nums[0];

        while(leftIndex < rightIndex){
            mid = (leftIndex + rightIndex) / 2;
            //无法判断左右哪边是升序序列
            if(nums[mid] == nums[leftIndex]){
                leftIndex++;
            }else if (nums[mid] < nums[leftIndex]){
                //右侧是升序序列
                if(nums[mid] < smallest){
                    smallest = nums[mid];
                    leftIndex++;
                    rightIndex = mid;
                }
            }else{
                //左侧是升序序列
                if(nums[leftIndex] < smallest) smallest = nums[leftIndex];
                leftIndex = mid + 1;
            }
        }
        return smallest;
    }

    public int findMinAns(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }


}

