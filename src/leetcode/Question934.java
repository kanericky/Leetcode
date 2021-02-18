package leetcode;

import java.util.*;
import java.util.logging.Logger;

/**
 * @author kanericky
 * @version 1.0
 */


public class Question934 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        };
        int[][] grid2 = {
                {0, 0, 1, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println(shortestBridge(grid));
        System.out.println(shortestBridge(grid2));

    }

    public static int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> points = new LinkedList<>();

        boolean visited = false;

        //使用dfs找到岛屿边界
        for(int i = 0; i < m; i++){
            if(visited) break;
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    visited = true;
                    dfs(points, grid, m, n, i, j);
                    break;
                }
            }
        }

        //使用bfs找到最短桥
        int x, y;
        int level = 0;

        int[] directionX = new int[]{0,0,1,-1};
        int[] directionY = new int[]{1,-1,0,0};

        while(!points.isEmpty()){
            level++;
            int pointSize = points.size();
            for(int index = 0; index < pointSize; index++){
                Point tempPoint = points.poll();
                if(tempPoint == null){
                    Logger.getGlobal().info("Point is null");
                    break;
                }
                for(int i = 0; i < 4; i++){
                    x = tempPoint.x + directionX[i];
                    y = tempPoint.y + directionY[i];

                    if(x >= 0 && x < m && y >= 0 && y < n){
                        if(grid[x][y] == 2)
                            continue;
                        if(grid[x][y] == 1)
                            return level;
                        points.offer(Point.createPoint(x,y));
                        grid[x][y] = 2;
                    }
                }
            }
        }
        return 0;
    }

    private static void dfs(Queue<Point> points, int[][] grid, int m, int n, int currentX, int currentY){
        if(currentX < 0 || currentX >= m || currentY < 0 || currentY >= n || grid[currentX][currentY] == 2)
            return;

        if(grid[currentX][currentY] == 0){
            points.offer(Point.createPoint(currentX, currentY));
            return;
        }

        grid[currentX][currentY] = 2;
        int[] directionX = new int[]{0,0,1,-1};
        int[] directionY = new int[]{1,-1,0,0};

        for(int i = 0; i < 4; ++i){
            int newX = currentX + directionX[i];
            int newY = currentY + directionY[i];
            dfs(points, grid, m, n, newX, newY);
        }
    }

    private static class Point{
        public int x;
        public int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Point createPoint(int x, int y){
            return new Point(x, y);
        }
    }
}
