package leetcode;

import java.util.*;

/**
 * 1207. 独一无二的出现次数
 * 难度:简单

 * Author: RUIQI ZHANG
 * DATE: 28/10/2020

 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 */


public class Question1207 {
    public static void main(String[] arg){
        int[] arr = {-3,0,1,-3,1,1,9,-3,10,0};
        //System.out.println(uniqueOccurrences(arr));

        //HashSet properties..
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        // the value is in the set, then it won't add again and return false...
        // Return true if the value is added to the set, false otherwise...
        System.out.println(set.add(1));
        System.out.println(set.add(2));

        System.out.println(set);

    }


    public static boolean uniqueOccurrences(int[] arr) {

        /** Solution A
        /** If the size of the arr is 0 or 1, it must be true...
        if(arr.length <= 1){
            return true;
        }

        boolean contain;
        ArrayList<leetcode.Number> occurrence= new ArrayList<>();
        ArrayList<Integer> times = new ArrayList<>();
        for(int num:arr){
            contain = false;
            for(int i = 0; i < occurrence.size(); i++){
                if(occurrence.get(i)._num == num){
                    occurrence.get(i)._times++;
                    contain = true;
                }
            }
            if(contain == false) occurrence.add(new leetcode.Number(num));
        }

        for(leetcode.Number num:occurrence){
            for(int i = 0; i < times.size(); i++){
                if(times.get(i) == num._times){
                    return false;
                }
            }
            times.add(num._times);
        }
        return true;*/

        //Solution B Using Hashing map (similar to solution A, but more native...)
        if(arr == null || arr.length == 1) return true;

        HashMap<Integer, Integer> numCollection = new HashMap<>();

        //Build a new hashmap...
        for(int i = 0; i < arr.length; i++){
            if(!numCollection.containsKey(arr[i])){
                numCollection.put(arr[i], 1);
            }else{
                numCollection.put(arr[i], numCollection.get(arr[i]) + 1);
            }
        }

        //Use set to check whether there is the same num...
        HashSet<Integer> set = new HashSet<>();
        for (Integer key: numCollection.keySet()){
            //Set can have same value....
            if(!set.add(numCollection.get(key))){
                return false;
            }
        }
        return true;
    }

}

class Number{
    int _num;
    int _times;

    public Number(int num){
        this._num = num;
        this._times = 1;
    }

    @Override
    public String toString() {
        return _num + ": " + _times;
    }
}