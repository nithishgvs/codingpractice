package main.arrayshashing;

import org.junit.Test;

import java.util.*;

public class CamelcaseMatching_1023 {


    public List<Boolean> camelMatch(String[] queries, String pattern) {

        List<Boolean> result = new ArrayList<>();

        for (String q : queries) {
            result.add(isMatch(q, pattern));
        }

        return result;
    }

    private Boolean isMatch(String q, String pattern) {
        int j = 0;
        for (int i = 0; i < q.length(); i++) {
            char ch = q.charAt(i);
            if (j < pattern.length() && ch == pattern.charAt(j)) {
                j++;
            } else if (Character.isUpperCase(ch)) {
                return false;
            }
        }

        return j == pattern.length();
    }

    @Test
    public void test() {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        System.out.println(camelMatch(queries, "FB"));
    }
}
