package leetcode;

/**
 * @author kanericky
 * @version  1.0
 */

public class Question221 {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'0','1'},
                {'1','0'}
        };

        System.out.println(maximalSquare(matrix));
    }

    //对于在矩阵内搜索正方形或长方形的题型，一种常见的做法是定义一个二维 dp 数组，
    // 其中 dp[i][j] 表示满足题目条件的、以 (i, j) 为右下角的正方形或者长方形的属性。
    // 对于本题，则表示 以 (i, j) 为右下角的全由 1 构成的最大正方形面积。
    // 如果当前位置是 0，那么 dp[i][j] 即为 0;如果 当前位置是 1，我们假设 dp[i][j] = k2，其充分条件为 dp[i-1][j-1]、dp[i][j-1] 和 dp[i-1][j] 的值必须
    // 都不小于 (k − 1)2，否则 (i, j) 位置不可以构成一个边长为 k 的正方形。同理，如果这三个值中的的最小值为 k − 1，则 (i, j)
    // 位置一定且最大可以构成一个边长为 k 的正方形。

    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length;
        int maxSide = 0;

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '1')
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }

        return maxSide * maxSide;
    }
}
