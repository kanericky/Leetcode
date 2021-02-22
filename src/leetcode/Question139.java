package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanericky
 * @version  1.0
 */
public class Question139 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("apple");
        list1.add("pen");
        System.out.println(wordBreak("applepenapple", list1));
    }

    //类似于完全平方数分割问题，这道题的分割条件由集合内的字符串决定，因此在考虑每个分割位置时,需要遍历字符串集合，
    // 以确定当前位置是否可以成功分割。注意对于位置 0，需要初 始化值为真。
    public static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        if(length == 0) return false;
        boolean[] dp = new boolean[length+1];
        dp[0] = true;

        for(int i = 1; i <= length; i++){
            for(String string : wordDict){
                int len = string.length();
                if(i >= len && s.substring(i-len, i).equals(string))
                    dp[i] = dp[i] || dp[i-len];
            }
        }
        return dp[length];
    }



}
