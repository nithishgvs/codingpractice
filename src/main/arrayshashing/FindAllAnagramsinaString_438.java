package main.arrayshashing;

import org.junit.Test;

import java.util.*;

public class FindAllAnagramsinaString_438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        int start = 0;
        Map<Character, Integer> sMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            sMap.put(s.charAt(end), sMap.getOrDefault(s.charAt(end), 0) + 1);

            if (end - start + 1 > p.length()) {
                char leftChar = s.charAt(start);
                int freq = sMap.get(leftChar);

                if (freq == 1)
                    sMap.remove(leftChar);
                else
                    sMap.put(leftChar, freq - 1);

                start++;
            }

            if (sMap.equals(pMap)) {
                result.add(start);
            }
        }

        return result;
    }

    @Test
    public void test() {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

}
