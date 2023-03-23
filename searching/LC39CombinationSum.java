package searching;

import java.util.ArrayList;
import java.util.List;

public class LC39CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
    }

    static List<List<Integer>> combinations = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(target, candidates, new ArrayList<>(), 0);
        return combinations;
    }

    public static void dfs(int target, int[] candidates, List<Integer> path, int index) {
        if (target == 0) {
            combinations.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                path.add(candidates[i]);
                dfs(target - candidates[i], candidates, path, i);
                path.remove(path.size() - 1);
            }
        }
    }
}
