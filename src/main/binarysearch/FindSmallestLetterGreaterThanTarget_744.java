package main.binarysearch;

import org.junit.Test;

public class FindSmallestLetterGreaterThanTarget_744 {

    public char nextGreatestLetter(char[] letters, char target) {

        char res = '\0';
        int l = 0;
        int h = letters.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (letters[mid] - 'a' > target - 'a') {
                res = letters[mid];
                h = mid - 1;
            } else {
                //same character found or lower one found so we try towards the right
                l = mid + 1;
            }
        }
        return res == '\0' ? letters[0] : res;
    }

    @Test
    public void test() {
        char[] letters = {'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
        System.out.println(nextGreatestLetter(letters, 'e'));
        ;
    }
}
