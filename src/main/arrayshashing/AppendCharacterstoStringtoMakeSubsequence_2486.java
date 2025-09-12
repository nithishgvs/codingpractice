package main.arrayshashing;

import org.junit.Test;

public class AppendCharacterstoStringtoMakeSubsequence_2486 {
    public int appendCharacters(String s, String t) {

        int sIndex = 0, tIndex = 0;

        while (tIndex < t.length() && sIndex < s.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }
            sIndex++;

        }

        return tIndex < t.length() ? t.length() - tIndex  : 0;

    }

    @Test
    public void test() {
        //System.out.println(appendCharacters("coaching", "coding"));
        //System.out.println(appendCharacters("abcde", "a"));
        System.out.println(appendCharacters("z", "abcde"));
    }
}
