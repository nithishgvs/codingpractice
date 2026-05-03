package main.arrayshashing;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement_2404 {

    public int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }

        int answer = -1;
        int maxFreq = 0;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int value = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFreq || (frequency == maxFreq && value < answer)) {
                maxFreq = frequency;
                answer = value;
            }
        }

        return answer;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 2, 2, 4, 4, 1};
        System.out.println(mostFrequentEven(nums));
    }
}
