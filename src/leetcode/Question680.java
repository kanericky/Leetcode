package leetcode;

import javax.print.attribute.standard.PrinterURI;
import java.util.HashMap;
import java.util.Map;

public class Question680 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("eeedsdef" ));
    }

    public static boolean validPalindrome(String s) {
        if(s.length() <= 2) return true;

        char[] chars = s.toCharArray();

        int leftIndex = 0, rightIndex = chars.length - 1;

        while (leftIndex <= rightIndex){
            if(chars[leftIndex] == chars[rightIndex]){
                leftIndex++;
                rightIndex--;
            }else{
                if(check(++leftIndex, rightIndex, chars) == false && check(--leftIndex, --rightIndex ,chars) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(int leftIndex, int rightIndex , char[] chars){
        while (leftIndex <= rightIndex){
            if(chars[leftIndex] == chars[rightIndex]){
                leftIndex++;
                rightIndex--;
            }else return false;
        }
        return true;
    }
}
