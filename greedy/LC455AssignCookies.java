package greedy;

import java.util.Arrays;

public class LC455AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; j < s.length; j++) {
            if (i < g.length && s[j] >= g[i]) {
                i++;
            }
        }

        return i;
    }
}
