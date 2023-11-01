package graph;

public class LC277FindTheCelebrity {

    /**
     * Ruling out candidate from 0 to n-1
     * And check whether candidate is valid
     */
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }

            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;
    }

    public boolean knows(int a, int b) {
        return true;
    }
}
