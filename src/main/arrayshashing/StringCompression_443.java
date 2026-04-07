package main.arrayshashing;

import org.junit.Test;

public class StringCompression_443 {

    public int compress(char[] chars) {

        int read = 0;
        int write = 0;
        //Write to same char array no extra space

        while (read < chars.length) {

            int count = 0;
            char currentChar = chars[read];

            while (read < chars.length && currentChar == chars[read]) {
                count++;
                read++;
            }

            chars[write++] = currentChar;

            if (count > 1) {
                String value = Integer.toString(count);
                for (int i = 0; i < value.length(); i++) {
                    chars[write++] = value.charAt(i);
                }
            }
        }

        return write;
    }

    @Test
    public void test() {
        char[] arr = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        char[] arr1 = {'a', 'a', 'b'};
        compress(arr);

    }
}
