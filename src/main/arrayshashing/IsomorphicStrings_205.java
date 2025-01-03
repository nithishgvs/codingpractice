package main.arrayshashing;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {

    public boolean isIsomorphic(String s, String t) {
        return helper(s).equals(helper(t));
    }

    private String helper(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }
            stringBuilder.append(map.get(s.charAt(i))).append("*");
        }

        return stringBuilder.toString();
    }

    @Test
    public void test() {
        System.out.println(isIsomorphic("egg", "add"));
    }
}
