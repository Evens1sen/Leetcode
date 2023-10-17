package searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class LC40CombinationSum2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, new ArrayList<>(), 0, target);
        return res;
    }

    public void backtracking(int[] candidates, List<Integer> path, int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            backtracking(candidates, path, i + 1, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
