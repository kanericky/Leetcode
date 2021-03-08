package leetcode;

import java.util.Arrays;

/**
 * @author kanericky
 */

public class Question48 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(nums);
        System.out.println(Arrays.deepToString(nums));
    }

    public static void rotate(int[][] matrix) {
        if(matrix.length == 0) return;

        int length = matrix.length;

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){

                matrix[i][j] = matrix[length-j-1][i];
            }
        }
    }
}
