package leetcode;

import java.util.HashMap;


/**
 * @author kanericky
 * @version 1.0
 */

public class Question003 {

    private Question003(){}

    public static int lengthOfLongestSubstring(String s) {
        int duplicateIndex = 0, length = s.length(), longest = 0;
        HashMap<Character, Integer> characters = new HashMap<>();

        if(length == 0) return 0;
        if(length == 1) return 1;

        for(int i = 0; i < length; i++){
            if (characters.containsKey(s.charAt(i)) && characters.get(s.charAt(i)) >= duplicateIndex) {
                duplicateIndex = characters.get(s.charAt(i))+1;
            }
            characters.put(s.charAt(i), i);
            longest = Math.max(longest, i - duplicateIndex + 1);
        }
        return longest;
    }

}

