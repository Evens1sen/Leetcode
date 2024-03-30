package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1851IntervalQuery {

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        System.out.println(Arrays.toString(minInterval(intervals, queries)));
    }

    public static int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] res = new int[n];
        Integer[] qIndex = new Integer[n]; // Only Integer array can be sorted by comparator
        for (int i = 0; i < n; i++) {
            qIndex[i] = i;
        }
        Arrays.sort(qIndex, Comparator.comparingInt(i -> queries[i]));
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int k = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1] - i[0]));
        for (int i = 0; i < n; i++) {
            int query = queries[qIndex[i]];
            while (k < intervals.length && intervals[k][0] <= query) {
                pq.add(intervals[k]);
                k++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < query) {
                pq.poll();
            }
            int[] min = pq.peek();
            res[qIndex[i]] = (pq.isEmpty() ? -1 : min[1] - min[0] + 1);
        }

        return res;
    }
}
