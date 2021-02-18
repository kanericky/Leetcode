package leetcode;

public class Question605 {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1}, 1));
    }

    //System.out.println(findMinArrowShots(new int[][]{{3,9}, {7,12}, {3,8}, {6, 8}, {9,10}, {2,9}, {0,9}, {3,9}, {0,6}, {2,8}}));

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1){
            if(flowerbed[0] == 0 && (n == 1 || n == 0)) return true;
            else return false;
        }

        int newFlower = 0;

        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                if(i-1 > 0 && i+1 < flowerbed.length){
                    if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                        flowerbed[i] = 1;
                        newFlower++;
                    }
                }else{
                    if(i == 0){
                        if(flowerbed[i+1] == 0){
                            flowerbed[i] = 1;
                            newFlower++;
                        }
                    }
                    if(i == flowerbed.length-1){
                        if(flowerbed[i-1] == 0){
                            flowerbed[i] = 1;
                            newFlower++;
                        }
                    }
                }
            }
        }

        if(newFlower >= n) return true;
        else return false;
    }
}
