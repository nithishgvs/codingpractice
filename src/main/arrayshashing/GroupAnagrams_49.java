package main.arrayshashing;

import org.junit.Test;

import java.util.*;

public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringListMap = new HashMap<>();
        for (String s : strs) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String key = String.valueOf(sArr);
            stringListMap.computeIfAbsent(key, sortedKey -> new ArrayList<>());
            stringListMap.get(key).add(s);
        }

        return new ArrayList<>(stringListMap.values());
    }


    @Test
    public void test() {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
