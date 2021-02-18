package leetcode;

import java.util.Arrays;

public class Question455 {
    public static void main(String[] args){
        System.out.println(findContentChildren(new int[]{10, 9 ,8 , 7}, new int[]{5, 6, 7, 8}));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int child = 0;
        int cookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while(child < g.length && cookie < s.length){
            if(g[child] <= s[cookie]) {
                child++;
            }
            cookie++;
        }

        return child;
    }
}
