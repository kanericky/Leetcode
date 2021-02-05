import java.util.*;

public class Question763 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> rangeList = new ArrayList<>();

        if(S.length() <= 1) {
            rangeList.add(S.length());
            return rangeList;
        }

        Map<Character, int[]> characterCounter = new HashMap();
        char[] charArray = S.toCharArray();

        for(int i = 0; i < charArray.length; i++){
            if(!characterCounter.containsKey(charArray[i]) ){
                characterCounter.put(charArray[i], new int[]{i,i});
            }else{
                characterCounter.get(charArray[i])[1] = i;
            }
        }

        ArrayList<int[]> indexRanges = new ArrayList<>();

        for(int[] a: characterCounter.values()) indexRanges.add(a);

        indexRanges.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] pos = indexRanges.get(0);

        for (int[] range: indexRanges) {
            if (range[0] < pos[1] && range[1] > pos[1]) {
                pos[1] = range[1];
            }
            if(range[1] > pos[1]){
                rangeList.add(pos[1] - pos[0] + 1);
                pos = range;
            }
        }
        rangeList.add(pos[1] - pos[0] + 1);

        return rangeList;

    }



}
