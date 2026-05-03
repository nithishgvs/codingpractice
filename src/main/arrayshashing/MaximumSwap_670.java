package main.arrayshashing;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MaximumSwap_670 {

    public int maximumSwap(int num) {

        char[] number = String.valueOf(num).toCharArray();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < number.length; i++) {
            map.put(number[i] - '0', i);
        }

        for (int i = 0; i < number.length; i++) {
            int currentDigit = number[i] - '0';

            for (int j = 9; j > -1; j--) {
                if (map.containsKey(j) && j > currentDigit && map.get(j) > i) {
                    char temp = number[i];
                    number[i] = (char) ('0' + j);
                    number[map.get(j)] = temp;
                    return Integer.parseInt(new String(number));
                }
            }
        }
        return num;
    }

    @Test
    public void test() {
        System.out.println(maximumSwap(9973));
    }
}
