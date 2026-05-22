package main.arrayshashing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII_350 {


    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int n : nums1) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int n : nums2) {
            if (freqMap.getOrDefault(n, 0) > 0) {
                result.add(n);
                freqMap.put(n, freqMap.get(n) - 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
