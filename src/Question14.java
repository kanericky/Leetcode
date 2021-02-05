import java.util.Arrays;
import java.util.Stack;

/**
 *
 * 14. 最长公共前缀
 * 难度 简单
 *
 * AUTHOR: RUIQI ZHANG
 * DATE: 28/10/2020
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 */

public class Question14 {

    public static void main(String[] args) {
        String[] words = {"ca","car"};
        System.out.println(longestCommonPrefix(words));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }

        //
        String ans = strs[0];
        boolean is_right = true;
        for(int i = 1; i < strs.length; i++){
            if(ans == ""){
                return ans;
            }
            if(ans.length() >= strs[i].length()){
                for(int j = 0; j < strs[i].length(); j++){
                    if(strs[i].toCharArray()[j] != ans.toCharArray()[j]){
                        ans = (String) ans.subSequence(0,j);
                        is_right = false;
                        break;
                    }
                }
                if(is_right) ans = (String) ans.subSequence(0, strs[i].length());

            }else{
                for(int j = 0; j < ans.length(); j++){
                    if(strs[i].toCharArray()[j] != ans.toCharArray()[j]){
                        ans = (String) ans.subSequence(0,j);
                    }
                }

            }
        }

        return ans;
    }

}
