package main.arrayshashing;

import org.junit.Test;

public class CustomSortString_791 {
    public String customSortString(String order, String s) {

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {

            int count = arr[order.charAt(i) - 'a'];

            while (count > 0) {
                sb.append(order.charAt(i));
                count--;
            }
            arr[order.charAt(i) - 'a'] = 0;
        }

        //remaining chars
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                sb.append((char) (i + 'a'));
                arr[i]--;
            }
        }

        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(customSortString("bcafg", "abcd"));
    }

}
