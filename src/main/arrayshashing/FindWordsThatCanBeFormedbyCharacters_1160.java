package main.arrayshashing;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedbyCharacters_1160 {

    public int countCharacters(String[] words, String chars) {
        int total = 0;
        int[] baseFreq = new int[26];
        for (char c : chars.toCharArray()) baseFreq[c - 'a']++;

        for (String word : words) {
            int[] freq = baseFreq.clone();
            boolean canForm = true;

            for (char c : word.toCharArray()) {
                if (--freq[c - 'a'] < 0) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) total += word.length();
        }
        return total;
    }


    @Test
    public void test() {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }
}
