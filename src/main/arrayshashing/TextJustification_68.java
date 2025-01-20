package main.arrayshashing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class TextJustification_68 {
    //Asked in Moveworks and I bombed
    //https://www.youtube.com/watch?v=TzMl4Z7pVh8
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int length = 0;
        int i = 0;
        while (i < words.length) {
            //Line complete scenario
            //line.size() which is nothing but number of spaces
            if (length + line.size() + words[i].length() > maxWidth) {

                int extraSpaces = maxWidth - length;
                int spaces = extraSpaces / Math.max(1, line.size() - 1);
                int remainder = extraSpaces % Math.max(1, line.size() - 1);

                for (int j = 0; j < Math.max(1, line.size() - 1); j++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(line.get(j) + " ".repeat(spaces));
                    if (remainder > 0) {
                        stringBuilder.append(" ");
                        remainder--;
                    }
                    line.set(j, stringBuilder.toString());
                }
                result.add(String.join("", line));
                line.clear();
                length = 0;
            }
            line.add(words[i]);
            length += words[i].length();
            i++;
        }
        String lastLine = String.join(" ", line);
        int spaces = maxWidth - lastLine.length();
        lastLine += " ".repeat(spaces);
        result.add(lastLine);
        return result;
    }

    @Test
    public void test() {
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        fullJustify(words, 16);
    }
}
