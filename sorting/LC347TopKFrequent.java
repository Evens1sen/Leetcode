package sorting;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC347TopKFrequent {

    // A bucket sort implementation
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (Integer key : freqMap.keySet()) {
            int frequency = freqMap.get(key);
            if (buckets[frequency] == null){
                buckets[frequency] = new LinkedList<>();
            }
            buckets[frequency].add(key);
        }

        List<Integer> topK = new LinkedList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null){
                continue;
            }

            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }

        int[] result = new int[k];
        int i = 0;
        for (Integer val : topK) {
            result[i++] = val;
        }

        return result;
    }

}
