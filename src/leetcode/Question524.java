package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question524 {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>(Arrays.asList("a", "b","c"));
        System.out.println(findLongestWord(s, d));
    }

    public static String findLongestWord(String s, List<String> d) {
        String longestByFar = "";
        char[] chars = s.toCharArray();

        for(int i = 0; i < d.size(); i++){
            int stringIndex = 0, dicIndex = 0, charNeedCounter = d.get(i).length();

            char[] currentWord = d.get(i).toCharArray();

            do{

                if(charNeedCounter == 0 && currentWord.length >= longestByFar.toCharArray().length){
                    if(currentWord.length == longestByFar.toCharArray().length && String.valueOf(currentWord).compareTo(longestByFar) < 0) {
                        longestByFar = String.valueOf(currentWord);
                    }else if(currentWord.length > longestByFar.toCharArray().length){
                        longestByFar = String.valueOf(currentWord);
                    }
                }

                if(dicIndex == currentWord.length || stringIndex == chars.length){
                    break;
                }

                if(chars[stringIndex] == currentWord[dicIndex]){
                    charNeedCounter--;
                    stringIndex++;
                    dicIndex++;
                }
                else stringIndex++;


            }while(true);

        }

        return longestByFar;
    }
}
