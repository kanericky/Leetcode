package leetcode;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question005 {

    private Question005(){}

    /**
     * 中心扩散法
     * @param s given string
     * @return longest palindrome substring
     */
    public static String longestPalindrome(String s){
        String ans = "";

        for(int i = 0;i < s.length(); i++){
            //偶数长度
            String string1 = isPalindrome(s, i, i);
            //奇数长度
            String string2 = isPalindrome(s, i, i+1);

            //更新ans
            ans = ans.length() > string1.length() ? ans : string1;
            ans = ans.length() > string2.length() ? ans : string2;
        }

        return ans;
    }

    private static String isPalindrome(String s, int left, int right){
        //进行扩散
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else {
                break;
            }
        }
        return s.substring(left+1, right);
    }


    /**
     * 动态规划
     * @param s given string
     * @return longest palindrome string
     */
    public static String longestPalindromeSolution1(String s) {
        int length = s.length();

        if(length == 0) return "";
        if(length == 1) return s;

        boolean[][] dp = new boolean[length][];
        String ans = "";

        for(int len = 0; len < length; len++){
            for(int index1 = 0; index1 + len < length; index1++){
                int index2 = index1 + len;
                if(len == 0){
                    dp[index1][index2] = true;
                }
                else if(len == 1){
                    dp[index1][index2] = s.charAt(index1) == s.charAt(index2);
                }else{
                    dp[index1][index2] = dp[index1 + 1][index2 - 1] && s.charAt(index1) == s.charAt(index2);
                }
                if(dp[index1][index2] && len + 1 > ans.length()){
                    ans = s.substring(index1, index2);
                }
            }
        }

        return ans;
    }
}
