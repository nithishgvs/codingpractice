package main.arrayshashing;

import org.junit.Test;

public class NumberofSeniorCitizens_2678 {

    public int countSeniors(String[] details) {
        int count = 0;
        for (String s : details) {
            if (Integer.valueOf(s.substring(11, 13)) > 60) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test1() {
        System.out.println(countSeniors(new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"}));
    }
}
