package sorting;

import java.util.PriorityQueue;

public class LC2462TotalCostToHireK {

    public static void main(String[] args) {
        int[] costs = {1, 2, 4, 1};
        int k = 3, candidates = 3;
        System.out.println(totalCost(costs, k, candidates));
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        int left = candidates - 1, right = costs.length - candidates;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        for (int i = 0; i < costs.length && (i <= left || i >= right); i++) {
            pq.add(new int[]{costs[i], i});
        }

        long res = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            int[] temp = pq.poll();
            res += temp[0];
            int index = temp[1];
            if (left < right - 1) {
                if (index <= left) {
                    left++;
                    pq.add(new int[]{costs[left], left});
                } else {
                    right--;
                    pq.add(new int[]{costs[right], right});
                }
            }
        }

        return res;
    }
}
