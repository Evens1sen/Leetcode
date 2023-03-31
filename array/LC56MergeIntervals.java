package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (res.isEmpty() || interval[0] > res.get(res.size() - 1)[1]) {
                res.add(interval);
            } else {
                if (interval[1] >= res.get(res.size() - 1)[1]) {
                    res.get(res.size() - 1)[1] = interval[1];
                }
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
