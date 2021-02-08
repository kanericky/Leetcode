import java.util.*;

/**
 * @author kanericky
 * @see <a herf = "top-k-frequent-elements/">https://leetcode-cn.com/problems/top-k-frequent-elements/</a>
 */

public class Question347 {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,2,3,3,4};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));

    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freCounter = new HashMap<Integer, Integer>();
        ArrayList<Integer> number = new ArrayList<>();

        for(int num : nums){
            if(!freCounter.containsKey(num)) freCounter.put(num, 1);
            else {
                int counter = freCounter.get(num);
                counter++;
                freCounter.put(num, counter);
            }
        }

        Comparator<Map.Entry<Integer, Integer>> mapComparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };

        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<Map.Entry<Integer, Integer>>(freCounter.entrySet());
        java.util.Collections.sort(mapList, mapComparator);

        for(Map.Entry<Integer, Integer> pair: mapList){
            number.add(pair.getKey());
            k--;
            if(k == 0) break;
        }

        return number.stream().mapToInt(Integer::intValue).toArray();

    }

}
