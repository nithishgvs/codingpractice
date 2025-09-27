package main.arrayshashing;

import org.junit.Test;

import java.util.*;

public class MajorityFrequencyCharacters_3962 {


    public String majorityFrequencyGroup(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();

        //char vs frequency
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        //Frequency vs list of chars
        Map<Integer, List<Character>> freqMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            freqMap.computeIfAbsent(entry.getValue(), _ -> new ArrayList<>()).add(entry.getKey());
        }


        //Sort the map using streams and map the value to string
        return freqMap.entrySet().stream().
                max(Comparator.<Map.Entry<Integer, List<Character>>>comparingInt(e -> e.getValue().size()).thenComparing(Map.Entry::getKey)).
                map(e -> {
                    StringBuilder sb = new StringBuilder();
                    e.getValue().forEach(sb::append);
                    return sb.toString();
                }).orElse("");

    }

    @Test
    public void test() {
        System.out.println(majorityFrequencyGroup("pfpfgi"));
    }
}
