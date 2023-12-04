package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC373FindKPairs {

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]
        );

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            pq.add(new int[]{0, i});
        }

        while (res.size() < k && !pq.isEmpty()) {
            int[] pair = pq.poll();
            res.add(List.of(nums1[pair[0]], nums2[pair[1]]));
            pair[0]++;
            if (pair[0] < nums1.length) {
                pq.add(pair);
            }
        }

        return res;
    }
}
