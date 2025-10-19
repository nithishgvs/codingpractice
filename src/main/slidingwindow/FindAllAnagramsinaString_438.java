package main.slidingwindow;

import org.junit.Test;

import java.util.*;

public class FindAllAnagramsinaString_438 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int[] pMap = new int[26];

        for (char c : p.toCharArray()) {
            pMap[c - 'a']++;
        }

        int[] wordMap = new int[26];

        int windowSize = p.length();

        for (int i = 0; i < s.length(); i++) {
            wordMap[s.charAt(i) - 'a']++;
            if (i >= windowSize) {
                wordMap[s.charAt(i - windowSize) - 'a']--;
            }
            if (Arrays.equals(wordMap, pMap))
                result.add(i - windowSize + 1);
        }


        return result;
    }


    @Test
    public void test() {
        findAnagrams("abab", "ab");
    }
}
