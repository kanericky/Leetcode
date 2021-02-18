package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Question435 {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2}, {1,2}, {1,2}}));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;

        //Slower when using Lambda expression...
        //Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int counter = 0;
        int arrayBound = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < arrayBound){
                counter++;
            }else{
                arrayBound = intervals[i][1];
            }
        }

        return counter;
    }
}
