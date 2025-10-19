package main.trees;

import org.junit.Test;

import java.util.HashMap;
import java.util.*;

public class ShortestDistancetoaCharacter_821 {

    public int[] shortestToChar(String s, char c) {

        Map<Character, TreeSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), new TreeSet<>());
            map.get(s.charAt(i)).add(i);
        }


        int[] result = new int[s.length()];
        TreeSet<Integer> treeSet = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            Integer floor = treeSet.floor(i);
            Integer ceiling = treeSet.ceiling(i);
            int left = floor == null ? Integer.MAX_VALUE : i - floor;
            int right = ceiling == null ? Integer.MAX_VALUE : ceiling - i;
            result[i] = Math.min(left, right);
        }


        return result;

    }

    @Test
    public void test() {
        System.out.println(shortestToChar("aaab", 'b'));
    }

}
