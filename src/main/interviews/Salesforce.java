package main.interviews;

public class Salesforce {

    /**
     * Question 1
     * To reduce the size of messages transmitted over the internet, a compression algorithm encodes consecutive repeating characters in a string.
     * Your task is to compress the given string using this rule:
     * <p>
     * Scan the string from left to right and group consecutive identical characters.
     * If a character appears once, add just the character to the output.
     * If a character appears more than once in a row, add the character followed by the number of consecutive occurrences.
     * <p>
     * Example
     * Suppose message = "aabbccca".
     * Output: "a2b2c3a"
     * Constraints
     * <p>
     * All characters in message are in the range ascii[a-z].
     * length of message ≤ 10⁵
     *
     * @param message
     * @return
     */
    public static String compressMessage(String message) {
        if (message == null || message.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < message.length()) {
            char currentChar = message.charAt(i);
            int count = 1;

            // Count consecutive identical characters
            while (i + count < message.length() && message.charAt(i + count) == currentChar) {
                count++;
            }

            // Append character (and count if > 1)
            result.append(currentChar);
            if (count > 1) {
                result.append(count);
            }

            i += count;
        }

        return result.toString();
    }

    public static int getMinOperations(int n) {
        int ops = 0;

        while (n != 0) {
            if ((n & 1) == 0) {
                // even → divide by 2
                n >>= 1;
            } else {
                // odd
                if (n == 1) {
                    ops++;
                    break;
                }
                // check last two bits
                if ((n & 3) == 1) {
                    // ends with 01 → subtract 1
                    n--;
                } else {
                    // ends with 11 → add 1
                    n++;
                }
                ops++;
            }
        }

        return ops;
    }

    public static void main(String[] args) {
        System.out.println(getMinOperations(7));
    }
}
