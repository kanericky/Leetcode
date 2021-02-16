import java.util.Arrays;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question547 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(grid));
    }

    public static int findCircleNum(int[][] isConnected) {
        //计数器
        int counter = 0;
        //boolean数组查看该index代表的节点是否被查看过
        boolean[] visited = new boolean[isConnected.length];
        Arrays.fill(visited, false);

        //遍历每一个节点（只需要一次，index就代表了哪一个index）
        for(int i = 0; i < isConnected.length; i++){
            //如果这个节点没有被访问
            if(!visited[i]){
                //增加counter并进行深度优先搜索
                counter++;
                dfs(isConnected, i, visited);
            }
        }
        return counter;
    }

    private static void dfs(int[][] grid, int currentIndex, boolean[] visited){
        //将当前节点设置为已访问
        visited[currentIndex] = true;

        //遍历这个点内未访问过的有效节点（深度优先）
        for(int newIndex = 0; newIndex < grid.length; newIndex++){
            if(grid[currentIndex][newIndex] == 1 && !visited[newIndex]){
                dfs(grid, newIndex, visited);
            }
        }
    }

}
