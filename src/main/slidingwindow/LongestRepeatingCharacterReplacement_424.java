package main.slidingwindow;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement_424 {

    public int characterReplacement(String s, int k) {

        int max = 0;

        int l = 0;

        int start = 0;

        Map<Character, Integer> freq = new HashMap<>();
        int maxFrequency = 0;

        while (l < s.length()) {

            char ch = s.charAt(l);

            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            //Find max frequency element and then check the window
            maxFrequency = Math.max(freq.get(ch), maxFrequency);
            int window = l - start + 1;

            if (window - maxFrequency > k) {
                freq.put(s.charAt(start), freq.get(s.charAt(start)) - 1);
                start++;
            } else {
                max = Math.max(max, window);
            }
            l++;

        }

        return max;
    }


    @Test
    public void test() {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
