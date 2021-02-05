import java.util.Arrays;

public class Question135 {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,3,2,2,1}));
    }

    public static int candy(int[] ratings) {
        int[] returnRatings = new int[ratings.length];
        for(int i = 0; i < returnRatings.length; i++){
            returnRatings[i] = 1;
        }

        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]) returnRatings[i] = returnRatings[i-1]+1;
        }

        for(int i = ratings.length - 1; i > 0; i--){
            if(ratings[i] < ratings[i-1]) returnRatings[i-1] = Math.max(returnRatings[i-1], returnRatings[i] + 1);
        }

        return Arrays.stream(returnRatings).sum();
    }
}
