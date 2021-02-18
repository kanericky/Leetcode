package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Question452 {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{4289383,51220269},{81692777,96329692},{57747793,81986128},{19885386,69645878},{96516649,186158070},{25202362,75692389},{83368690,85888749},{44897763,112411689},{65180540,105563966},{4089172,7544908}}));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }


    /*
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        if(points.length == 1) return 1;

        int _arrows = 1;
        boolean checker = false;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[1]-o2[0]) - (o1[1]-o1[0]);
            }
        });

        ArrayList<int[]> currentPointRange = new ArrayList<>();

        int[] currentPoint = points[0];
        currentPointRange.add(currentPoint);

        for(int i = 1; i < points.length; i++){
            currentPointRange.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[1]-o1[0]) - (o2[1]-o2[0]);
                }
            });
            for(int j = 0; j < currentPointRange.size(); j++){
                if ((points[i][1] >= currentPointRange.get(j)[0] && points[i][1] <= currentPointRange.get(j)[1]) ||
                        (points[i][0] <= currentPointRange.get(j)[1] && points[i][0] >= currentPointRange.get(j)[0]) ||
                        (points[i][0] <= currentPointRange.get(j)[0] && points[i][1] >= currentPointRange.get(j)[1])){
                    currentPoint = new int[]{Math.max(currentPointRange.get(j)[0], points[i][0]), Math.min(currentPointRange.get(j)[1], points[i][1])};
                    currentPointRange.remove(j);
                    currentPointRange.add(j, currentPoint);
                    checker = true;
                    break;
                }
            }
            if(checker == false) currentPointRange.add(points[i]);
            checker = false;
        }
        _arrows = currentPointRange.size();
        return _arrows;
    }
     */

}
