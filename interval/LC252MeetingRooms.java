package interval;

import java.util.Arrays;
import java.util.Comparator;

public class LC252MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] prev = null;
        for (int[] interval : intervals) {
            if (prev != null && interval[0] < prev[1]) {
                return false;
            }
            prev = interval;
        }
        return true;
    }
}
