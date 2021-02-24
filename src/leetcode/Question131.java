package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question131 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        int length = s.length();
        List<List<String>> ans = new ArrayList<>();
        if(length == 0) return ans;

        boolean[][] dp = new boolean[length][length];

        for(int i = 0; i < length; i++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i-j<2 || dp[j+1][i-1]))
                    dp[j][i] = true;
            }
        }
        dfs(dp, ans, s, 0, length, new ArrayList<>());
        return ans;
    }

    public static void dfs(boolean[][] dp, List<List<String>> ans, String s, int i, int n, ArrayList<String> temp){
        if(i==n)
            ans.add(new ArrayList<>(temp));
        for(int j = i; j < n; j++){
            if(dp[i][j]){
                temp.add(s.substring(i, j+1));
                dfs(dp, ans, s, j+1, n, temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static List<List<String>> practice(String s){
        int length = s.length();
        List<List<String>> ans = new ArrayList<>();
        if(length == 0) return ans;

        boolean[][] dp = new boolean[length][length];

        for(int i = 0; i < length; i++){
            for(int j = 0; j <= i; j++){
                //判断回文数
                if(s.charAt(i) == s.charAt(j) && (i-j<2 || dp[j+1][i-1]))
                    dp[i][j] = true;
            }
        }
        dfs(dp, ans, s, 0, length, new ArrayList<>());
        return ans;
    }

}
