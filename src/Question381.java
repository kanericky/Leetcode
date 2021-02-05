import java.util.*;

/**
 *
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 * 难度 困难
 *
 * AUTHOR: RUIQI ZHANG
 * DATE: 31/10/2020
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 *
 */

public class Question381 {

    RandomizedCollection obj = new RandomizedCollection();
    boolean param_1 = obj.insert(1);
    //boolean param_2 = obj.remove(1);
    //int param_3 = obj.getRandom();

}

class RandomizedCollection {

    //O(1) -> list(through index), Hashmap can achieve O(1)
    //Use hashMap to store(val, index), use list to store val...

    int n = 0; // Size
    HashMap<Integer, Set<Integer>> hashMap;
    ArrayList<Integer> objList;
    Random random;

    public RandomizedCollection(){
        this.hashMap = new HashMap<>();
        this.objList = new ArrayList<>();
        this.n = 0;
        this.random = new Random();
    }

    // Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     public boolean insert(int val) {
        Set set = hashMap.get(val);
        if(set == null) set = new HashSet();
        set.add(n);
        objList.add(val);
        hashMap.put(val, set);
        n++;

        return set.size() == 1;
     }



    /*
    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;

    /** Initialize your data structure here.
    public RandomizedCollection() {
        idx = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<Integer>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
        set.add(nums.size() - 1);
        idx.put(val, set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element.
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        Iterator<Integer> it = idx.get(val).iterator();
        int i = it.next();
        int lastNum = nums.get(nums.size() - 1);
        nums.set(i, lastNum);
        idx.get(val).remove(i);
        idx.get(lastNum).remove(nums.size() - 1);
        if (i < nums.size() - 1) {
            idx.get(lastNum).add(i);
        }
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the collection.
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
    */
}

