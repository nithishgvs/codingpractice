package main.arrayshashing;

import java.util.*;

class RandomizedSet {

    Random random;
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {

        if (map.containsKey(val)) {
            return false;
        }
        int index = list.size();
        list.add(index, val);
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        //get index from map
        int idx = map.get(val);
        int lastIdx = list.size() - 1;
        int lastValue = list.get(lastIdx);
        //put last element at idx
        list.set(idx, lastValue);
        //Remove value from array at lastIdx
        list.remove(lastIdx);
        map.put(lastValue, idx);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.remove(0); // Returns false as 2 does not exist in the set.
        randomizedSet.remove(0); // Returns false as 2 does not exist in the set.
        randomizedSet.insert(0); // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(0); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(0); // 2 was already in the set, so return false.
        //randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
