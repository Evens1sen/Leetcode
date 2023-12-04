package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC502IPO {

    public static void main(String[] args) {
        int k = 3, w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 2};
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int res = w;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < profits.length; i++) {
            pq.add(new int[]{profits[i], capital[i]});
        }

        int i = 0;
        List<int[]> cache = new ArrayList<>();
        while (i < k && !pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[1] > res) {
                cache.add(pq.poll());
            }

            if (pq.isEmpty()) {
                break;
            }

            int[] ipo = pq.poll();
            res += ipo[0];
            pq.addAll(cache);
            cache.clear();
            i++;
        }

        return res;
    }

}
