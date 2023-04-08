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
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // buckets = [l0, l1, l2, ..., ln]
        // We iterate from back to the front to get k numbers
        List<Integer> topK = new ArrayList<>();
        int j = nums.length;
        while (topK.size() < k && j >= 0) {
            if (buckets[j] == null) {
                j--;
                continue;
            }

            int bucketSize = buckets[j].size();
            if (bucketSize < k - topK.size()) {
                topK.addAll(buckets[j]);
            } else {
                topK.addAll(buckets[j].subList(0, k - topK.size()));
            }
            j--;
        }

        int[] res = new int[k];
        for (int a = 0; a < k; a++) {
            res[a] = topK.get(a);
        }
        return res;
    }

}
