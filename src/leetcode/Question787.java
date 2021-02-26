package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question787 {
    public static void main(String[] args) {
        int[][] flights = new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        System.out.println(findCheapestPrice(3, flights, 0 , 2, 1));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[K+1][n];

        for(int i = 0; i <= K; i++){
            Arrays.fill(flights[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < n; i++){
            if(flights[i][0] == src){
                dp[0][flights[i][1]] = flights[i][2];
            }
        }

        for(int i = 0; i <= K; i++){
            dp[i][src] = 0;
        }

        for(int i = 1; i < K; i++){
            for(int[] flight:flights){
                if(dp[i-1][flight[0]] != Integer.MAX_VALUE){
                    dp[i][flight[1]] = Math.min(dp[i][flight[1]], dp[i-1][flight[0] + flight[2]]);
                }
            }
        }
        return dp[K][dst] == Integer.MAX_VALUE ? -1 : dp[K][dst];
    }
}
