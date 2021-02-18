import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question077 {
    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] combination = new int[k];
        int count = 0;
        backTracing(ans, combination, count, 1, n, k);
        return ans;
    }

    /**
     *
     * @param ans store the answer
     * @param combination store each combination
     * @param count @range(0,k)
     * @param position the index of current number
     * @param n number of nums
     * @param k the size of each combination
     */
    private static void backTracing(List<List<Integer>> ans, int[] combination, int count, int position, int n, int k){
        //边界情况
        if(count == k){
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0; i< k; i++)
                tempList.add(combination[i]);
            ans.add(tempList);
            return;
        }

        for(int i = position; i <= n; ++i){
            combination[count++] = i;
            backTracing(ans, combination, count, i+1, n, k);
            --count;
        }
    }
}
