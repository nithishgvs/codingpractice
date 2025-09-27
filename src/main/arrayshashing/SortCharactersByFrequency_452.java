package main.arrayshashing;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCharactersByFrequency_452 {

    public String frequencySort(String s) {

        Map<Character, Integer> charFreqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            charFreqMap.put(s.charAt(i), charFreqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        return charFreqMap.entrySet().stream().
                sorted(Comparator.<Map.Entry<Character, Integer>>comparingInt(Map.Entry::getValue)
                        .reversed())
                .map(e -> String.valueOf(e.getKey()).repeat(e.getValue())).collect(Collectors.joining());

    }

    @Test
    public void test() {
        frequencySort("tree");
    }
}
