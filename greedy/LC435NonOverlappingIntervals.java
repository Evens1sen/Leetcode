package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LC435NonOverlappingIntervals {

    // The interval schedule problem
    // The classic greedy solution with O(n) complexity
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 0;
        int[] prev = null;
        for (int[] interval : intervals) {
            if (prev == null || interval[0] >= prev[1]) {
                cnt++;
                prev = interval;
            }
        }
        return intervals.length - cnt;
    }

}
