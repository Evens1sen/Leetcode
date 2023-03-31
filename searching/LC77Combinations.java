package searching;

import java.util.ArrayList;
import java.util.List;

public class LC77Combinations {

    List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, new ArrayList<>(), 0, k);
        return combinations;
    }

    public void backtracking(int n, List<Integer> track, int start, int k) {
        if (track.size() == k) {
            combinations.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backtracking(n, track, i + 1, k);
            track.remove(track.size() - 1);
        }
    }
}
