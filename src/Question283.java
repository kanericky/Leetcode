import java.util.Arrays;

public class Question283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12,12,34,12,2,435,67};
        quickSort(nums, 0, nums.length-1);
        //moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int pointer1 = 0;
        int pointer2 = 0;
        int counter = 0;

        if(nums.length==1) {
            return;
        } else {
            while(pointer2<nums.length){
                if(nums[pointer2] != 0){
                    nums[pointer1] = nums[pointer2];
                    pointer1++;
                }else{
                    counter++;
                }
                pointer2++;
            }
        }

        for(int i = nums.length-counter; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    static void quickSort(int[] a, int l, int r){
        //Step01: Check whether the array's left index == right index
        if(l >= r) return;

        //Step02
        int i = l, j = r;
        int key = a[l];

        //Step03
        while (i<j){
            while (i < j && a[j] >= key){
                j--;
            }
            if(i < j){
                a[i] = a[j];
                i++;
            }

            while (i < j && a[i] < key){
                i++;
            }
            if(i < j){
                a[j] = a[i];
                j--;
            }
        }

        a[i] = key;
        quickSort(a, l, i-1);
        quickSort(a, i+1, r);
    }

    void quicKSort(int[] a, int l, int r){
        if(l >= r) return;

        int i = l; int j = r; int key = a[l];

        while(i < j){
            while(i < j && a[j] >= key){
                j--;
            }
            if(i<j){
                a[i] = a[j];
                i++;
            }

            while(i < j && a[i] < key){
                i++;
            }
            if(i<j){
                a[j] = a[i];
                j--;
            }
        }

        a[i] = key;
        quickSort(a, l, i-1);
        quickSort(a, i+1, r);
    }
}
