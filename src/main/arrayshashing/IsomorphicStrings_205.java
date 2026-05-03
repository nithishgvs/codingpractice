package main.arrayshashing;

import org.junit.Test;

public class IsomorphicStrings_205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sLastSeen = new int[256];
        int[] tLastSeen = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char source = s.charAt(i);
            char target = t.charAt(i);

            if (sLastSeen[source] != tLastSeen[target]) {
                return false;
            }

            // Store i + 1 so that 0 can remain the sentinel for "not seen yet".
            sLastSeen[source] = i + 1;
            tLastSeen[target] = i + 1;
        }

        return true;
    }

    @Test
    public void test() {
        System.out.println(isIsomorphic("egg", "add"));
    }
}
