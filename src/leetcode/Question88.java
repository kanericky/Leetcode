package leetcode;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;

public class Question88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        merge(nums1,1,nums2,0);
        System.out.println(Arrays.toString(nums1));
    }

    /*
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m-- + n-- - 1;
        while(m >= 0 && n >= 0){
            nums1[pos--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while(n >= 0){
            nums1[pos--] = nums2[n--];
        }
    }
}
