package leetcode;

import java.util.Arrays;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question542 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1,0,1,1},
                {1,1,0,0,1},
                {0,0,0,1,0},
                {1,0,1,1,1},
                {1,0,0,0,1}
        };

        int[][] ans = updateMatrix(grid);
        for(int[] a : ans)
            System.out.println(Arrays.toString(a));
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE-1);

        //左上至右下
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0)
                    dp[i][j] = 0;
                else{
                    if(i > 0)
                        dp[i][j] = Math.min(dp[i-1][j] + 1, dp[i][j]);
                    if(j > 0)
                        dp[i][j] = Math.min(dp[i][j-1] + 1, dp[i][j]);
                }
            }
        }

        //从右下至左上
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(matrix[i][j] != 0){
                    if(i < m-1)
                        dp[i][j] = Math.min(dp[i+1][j] + 1, dp[i][j]);
                    if(j < n-1 )
                        dp[i][j] = Math.min(dp[i][j+1] + 1, dp[i][j]);
                }
            }
        }

        for(int[] a : dp)
            System.out.println(Arrays.toString(a));

        return dp;
    }
}
