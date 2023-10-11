package sorting;

import java.util.*;

public class LC347TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        return topKFrequentBucket(nums, k);
    }

    // A bucket sort implementation
    public static int[] topKFrequentBucket(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List[] buckets = new List[nums.length + 1];
        for (Integer num : freq.keySet()) {
            int f = freq.get(num);
            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(num);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }

            List<Integer> cur = buckets[i];
            for (Integer c : cur) {
                res[index] = c;
                index++;
                if (index == k) {
                    return res;
                }
            }
        }

        return res;
    }

}
