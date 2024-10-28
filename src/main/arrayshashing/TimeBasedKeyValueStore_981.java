package main.arrayshashing;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore_981 {

    class TimeMap {

        Map<String, TreeMap<Integer, String>> helperMap;

        public TimeMap() {
            helperMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {

            if (!helperMap.containsKey(key))
                helperMap.put(key, new TreeMap<>());

            helperMap.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {

            if (helperMap.containsKey(key)) {
                Integer floorKey = helperMap.get(key).floorKey(timestamp);
                if (floorKey != null)
                    return helperMap.get(key).get(floorKey);
            }

            return "";

        }
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore_981 object = new TimeBasedKeyValueStore_981();
        TimeMap timeMap = object.new TimeMap();
        timeMap.set("love","high",10);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.set("love","low",20);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("love", 5);         // return "bar"
        timeMap.get("love", 10);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.get("love", 15); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("love", 20);        // return "bar2"
        timeMap.get("love", 25);         // return "bar2"
    }
}
