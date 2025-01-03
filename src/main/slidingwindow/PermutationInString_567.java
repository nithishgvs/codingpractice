package main.slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString_567 {

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> map1 = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int end = 0;

        Map<Character, Integer> map2 = new HashMap<>();

        while (end < s2.length()) {
            map2.put(s2.charAt(end), map2.getOrDefault(s2.charAt(end), 0) + 1);
            if (end - start + 1 > s1.length()) {
                Integer value = map2.get(s2.charAt(start));
                if (value > 1) {
                    map2.put(s2.charAt(start), --value);
                } else {
                    map2.remove(s2.charAt(start));
                }
                start++;
            }

            if (map1.equals(map2)) {
                return true;
            }
            end++;
        }

        return false;
    }


    @Test
    public void test() {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
