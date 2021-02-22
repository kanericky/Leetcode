package leetcode;

import java.util.Arrays;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question91 {
    public static void main(String[] args) {
        System.out.println(numDecodings("10"));
    }

    public static int numDecodings(String s) {
        int length = s.length();
        if(length == 0) return 0;
        int prev = s.charAt(0) - '0';
        if(prev == 0) return 0;
        if(length == 1) return 1;

        int[] dp = new int[length + 1];
        Arrays.fill(dp, 1);

        for(int i = 2; i <= length; i++){
            int cur = s.charAt(i-1) - '0';
            if((prev == 0 || prev > 2) && cur == 0)
                return 0;
            // 10 ~ 19 / 20 ~ 26
            if((prev == 1) || prev == 2 && cur < 7){
                if(cur > 0)
                    dp[i] = dp[i-2] + dp[i-1];
                else
                    dp[i] = dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
            prev = cur;
        }
        return dp[length];
    }
}
