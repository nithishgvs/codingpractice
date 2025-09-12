package main.binarysearch;

import java.util.*;

public class TimeMap {

    Map<String, List<Map.Entry<Integer, String>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(Map.entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Map.Entry<Integer, String>> value = timeMap.get(key);
        if (value == null)
            return "";

        int l = 0, h = value.size() - 1;

        int ans = -1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (value.get(mid).getKey() <= timestamp) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }


        return ans == -1 ? "" : value.get(ans).getValue();
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1));         // return "bar"
        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4));         // return "bar2"
        System.out.println(timeMap.get("foo", 5));         // return "bar2"
    }
}
