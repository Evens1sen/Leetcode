package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LC452BurstBalloons {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 0;
        int[] prev = null;
        for (int[] cur : points) {
            if (prev == null || cur[0] > prev[1]) {
                cnt++;
                prev = cur;
            }
        }
        return cnt;
    }
}
