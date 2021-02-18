package leetcode;

import java.util.Arrays;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairsDP(int n) {
        if(n <= 2) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        for(int i = 2; i <= n; i++) dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }

    public static  int climbStairs(int n){
        //优化 因为dp[n]仅和dp[n-1] dp[n-2]有关
        if(n <= 2) return n;
        int previous1 = 2, previous2 = 1, current = 0;
        for(int i = 2; i < n; i++){
            current = previous1 + previous2;
            previous2 = previous1;
            previous1 = current;
        }
        return current;
    }
}
