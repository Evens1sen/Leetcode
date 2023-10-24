package binary;

import java.util.*;

public class LC981TimeBasedKVStore {

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        System.out.println(timeMap.get("love", 5));
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
        System.out.println(timeMap.get("love", 25));
    }

    static class TimeMap {

        Map<String, List<Pair>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new Pair(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }

            List<Pair> list = map.get(key);
            return search(list, timestamp);
        }

        public String search(List<Pair> lst, int timestamp) {
            int left = 0;
            int right = lst.size();
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (lst.get(mid).timestamp <= timestamp) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left - 1 >= 0 ? lst.get(left - 1).value : "";
        }

        static class Pair {
            int timestamp;
            String value;

            public Pair(String value, int timestamp) {
                this.timestamp = timestamp;
                this.value = value;
            }
        }
    }

}


