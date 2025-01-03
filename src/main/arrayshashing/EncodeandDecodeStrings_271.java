package main.arrayshashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodeandDecodeStrings_271 {

    class Codec {

        final Map<String, List<String>> memory = new HashMap<>();

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str : strs) {
                stringBuilder.append(str).append("|");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            memory.put(stringBuilder.toString(), strs);
            return stringBuilder.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            return memory.get(s);
        }
    }


    public static void main(String[] args) {
        EncodeandDecodeStrings_271 object = new EncodeandDecodeStrings_271();
        Codec codec = object.new Codec();
        codec.decode(codec.encode(List.of("", "")));
    }
}
