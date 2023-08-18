package array;

import java.util.Arrays;

public class LC274HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                h = Math.max(citations.length - i, h);
            }
        }
        return h;
    }

    // TODO
    public int binarySolution(int[] citations) {
        return 0;
    }
}
