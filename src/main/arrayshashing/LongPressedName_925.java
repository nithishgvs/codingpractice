package main.arrayshashing;

import org.junit.Test;

public class LongPressedName_925 {

    public boolean isLongPressedName(String name, String typed) {
        int start1 = 0;
        int start2 = 0;
        int end1 = name.length();
        int end2 = typed.length();

        while (start1 < end1 && start2 < end2) {

            char c1 = name.charAt(start1);
            char c2 = typed.charAt(start2);
            if (c1 != c2)
                return false;

            int count1 = 0;

            while (start1 < end1 && c1 == name.charAt(start1)) {
                start1++;
                count1++;
            }

            int count2 = 0;

            while (start2 < end2 && c2 == typed.charAt(start2)) {
                start2++;
                count2++;
            }

            if (count1 > count2)
                return false;

        }


        return start1 == end1 && start2 == end2;
    }

    @Test
    public void test() {
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
    }
}
