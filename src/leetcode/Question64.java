package leetcode;

public class Question64 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(grid));
    }

    /*
    我们可以定义一个同样是二维的 dp 数组，其中 dp[i][j] 表示从左上角开始到 (i, j) 位置的最 优路径的数字和。
    因为每次只能向下或者向右移动，我们可以很容易得到状态转移方程 dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]，其中 grid 表示原数组。
     */

    public static int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;

        int i = grid.length, j = grid[0].length;
        int[][] dp = new int[i][j];

        for(int x = 0; x < i; x++){
            for(int y = 0; y < j; y++){
                if(x == 0 && y == 0)
                    dp[x][y] = grid[x][y];
                else if(x == 0)
                    dp[x][y] = dp[x][y-1] + grid[x][y];
                else if(y == 0)
                    dp[x][y] = dp[x-1][y] + grid[x][y];
                else
                    dp[x][y] = Math.min(dp[x-1][y], dp[x][y-1]) + grid[x][y];
            }
        }

        return dp[i-1][j-1];
    }
}

