import org.junit.Test;

import java.util.Map;
import java.util.Stack;

/**
 * Max Area of Island (Easy)
 * @author kanericky
 * @version 1.0
 */

public class Question695 {

    public static void main(String[] args) {
        int[][] island = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(island));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        //记录最大面积
        int area = 0;

        //遍历每一个节点
        for(int i = 0; i != grid.length; i++){
            for(int j = 0; j != grid[0].length; j++){

                //当前节点能组成的最大面积
                int localArea = 0;

                //先入后出实现深度优先
                Stack<Node> nodes = new Stack<>();
                //将当前节点入栈
                nodes.push(new Node(i,j));

                //当栈未被清空时
                while(!nodes.isEmpty()){
                    //当前检查节点
                    Node currentNode = nodes.pop();
                    int currentX = currentNode._x, currentY = currentNode._y;

                    //边界情况
                    if(currentX < 0 || currentY < 0 || currentX >= grid.length || currentY >= grid[0].length || grid[currentX][currentY] != 1)
                        continue;

                    //设置当前面积
                    localArea += 1;
                    grid[currentX][currentY] = 0;

                    //开始搜索
                    int[] directionX = new int[]{0,0,1,-1}, directionY = new int[]{1,-1,0,0};
                    for(int index = 0; index != 4; index++){
                        nodes.push(new Node(currentX + directionX[index], currentY + directionY[index]));
                    }
                }
                area = Math.max(area, localArea);
            }
        }

        return area;
    }

    private static class Node{
        int _x;
        int _y;

        Node(int i, int j){
            _x = i;
            _y = j;
        }
    }


    public static int maxAreaOfIslandWithRecursion(int[][] grid) {
        int area = 0;

        //遍历每一个节点，并对其进行深度优先搜索
        for(int i = 0; i != grid.length; i++){
            for(int j = 0; j != grid[0].length; j++){
                area = Math.max(area, dfs(grid, i , j));
            }
        }
        return area;
    }

    private static int dfs(int[][] grid, int currentX, int currentY){
        //边界情况
        if(currentX < 0 || currentY < 0 ||currentX == grid.length || currentY == grid[0].length || grid[currentX][currentY] != 1)
            return 0;

        //在单次深度优先搜索时将遍历过的节点设置为0
        grid[currentX][currentY] = 0;

        //当前节点的面积
        int localArea = 1;

        //遍历方向
        int[] directionX = new int[]{0, 0, 1, -1};
        int[] directionY = new int[]{1, -1, 0, 0};

        for(int i = 0; i !=  4; i++){
            int newX = currentX + directionX[i];
            int newY = currentY + directionY[i];
            localArea += dfs(grid, newX, newY);
        }

        return localArea;
    }

}
