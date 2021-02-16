import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question417 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(matrix));
    }

    static int[] directionX = new int[]{0,0,1,-1};
    static int[] directionY = new int[]{1,-1,0,0};

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> ans = new ArrayList<>();

        //输入为空则直接返回空List
        if(matrix.length == 0) return ans;

        int m = matrix.length;
        int n = matrix[0].length;

        //可以到达太平洋
        boolean[][] canReach_p = new boolean[m][n];
        //可以到达大西洋
        boolean[][] canReach_a = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                canReach_a[i][j] = false;
                canReach_p[i][j] = false;
            }
        }

        //从大西洋开始进行搜索
        for (int i = 0; i < m; i++) {
            dfs(matrix, canReach_a, i, n-1);
            dfs(matrix, canReach_p, i, 0);
        }

        //从太平洋开始进行搜索
        for (int i = 0; i < n; i++) {
            dfs(matrix, canReach_a, m-1, i);
            dfs(matrix, canReach_p, 0, i);
        }

        //取出符合条件的坐标
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReach_a[i][j] && canReach_p[i][j]) {
                    List<Integer> node = new ArrayList<>();
                    node.add(i);
                    node.add(j);
                    ans.add(node);
                }
            }
        }

        return ans;
    }

    private static void dfs(int[][] matrix, boolean[][] canReach, int x, int y){
        if(canReach[x][y])
            return;

        canReach[x][y] = true;

        for(int i = 0; i < 4; i++){
            int newX = x + directionX[i];
            int newY = y + directionY[i];

            //修改边界判断条件以符合题目要求
            if(newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && matrix[x][y] <= matrix[newX][newY]){
                dfs(matrix, canReach, newX, newY);
            }
        }
    }
}
