package greedy;

import java.util.Arrays;

public class LC435NonOverlappingIntervals {

    // The interval schedule problem
    // The classic greedy solution with O(n) complexity
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> (i1[1] - i2[1]));

        int n = intervals.length;
        int cnt = 1;
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                cnt++;
                end = interval[1];
            }
        }

        return n - cnt;
    }

}
