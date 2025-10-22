package main.slidingwindow;

import org.junit.Test;

import java.util.Set;

public class MaximumNumberofVowelsinaSubstringofGivenLength_1456 {

    public int maxVowels(String s, int k) {

        int max = 0;
        int left = 0;
        int currentSum = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for (int right = 0; right < s.length(); right++) {

            if (vowels.contains(s.charAt(right))) {
                currentSum++;
            }

            while (right - left + 1 > k) {
                if (vowels.contains(s.charAt(left))) {
                    currentSum--;
                }
                left++;
            }

            max = Math.max(max, currentSum);

        }
        return max;

    }

    @Test
    public void test() {
        System.out.println(maxVowels("abciiidef", 3));
    }
}
