package main.arrayshashing;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords_804 {

    private static final String[] MORSE_CODES = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {

        Set<String> uniqueTransformations = new HashSet<>();

        for (String word : words) {
            StringBuilder transformation = new StringBuilder(word.length() * 4);
            for (int i = 0; i < word.length(); i++) {
                transformation.append(MORSE_CODES[word.charAt(i) - 'a']);
            }
            uniqueTransformations.add(transformation.toString());
        }
        return uniqueTransformations.size();
    }

    @Test
    public void test() {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }
}
